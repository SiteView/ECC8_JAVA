; Script created by zhngping.wang.

; HM NIS Edit Wizard helper defines
!define PRODUCT_NAME "SiteViewEccClient" ;产品名称
!define PRODUCT_VERSION "8.2" ;产品版本号
!define PRODUCT_PUBLISHER "DragonFlow, Inc." ;产品发行公司
!define PRODUCT_WEB_SITE "http://www.siteview.com" ;产品发行公司网址
!define PRODUCT_UNINST_KEY "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}"


; MUI 1.67 compatible ------
!include "MUI.nsh" ;引用新式用户界面

;Register Environmnet Variable

; MUI Settings
!define MUI_ABORTWARNING
!define MUI_ICON "logo.ico"  ;软件图标
!define MUI_UNICON "unInstall.ico" ;卸载图标

; Welcome page
!insertmacro MUI_PAGE_WELCOME
; License page
!define MUI_LICENSEPAGE_CHECKBOX
!insertmacro MUI_PAGE_LICENSE "siteviewlicense.rtf" ;授权文件
; Directory page
!insertmacro MUI_PAGE_DIRECTORY
; Instfiles page
!insertmacro MUI_PAGE_INSTFILES
; Finish page
;!insertmacro MUI_PAGE_FINISH

; Uninstaller pages
!insertmacro MUI_UNPAGE_INSTFILES

; Language files
!insertmacro MUI_LANGUAGE "SimpChinese"

; MUI end ------
BrandingText " http://www.siteview.com "
Name "${PRODUCT_NAME} ${PRODUCT_VERSION}"
OutFile "SiteView8.2(32bit)Client.exe"
InstallDir "C:\SiteView\SiteViewEcc8.2Client"
InstallDirRegKey HKLM "${PRODUCT_DIR_REGKEY}" ""
ShowInstDetails show
ShowUnInstDetails show
;--------------获取安装机器中的.net版本---------------
Function GetNetFrameworkVersion
Push $1
Push $0
ReadRegDWORD $0 HKLM "SOFTWARE\Microsoft\NET Framework Setup\NDP\v3.5" "Install"
ReadRegDWORD $1 HKLM "SOFTWARE\Microsoft\NET Framework Setup\NDP\v3.5" "Version"
StrCmp $0 1 KnowNetFrameworkVersion +1
ReadRegDWORD $0 HKLM "SOFTWARE\Microsoft\NET Framework Setup\NDP\v3.0\Setup" "InstallSuccess"
ReadRegDWORD $1 HKLM "SOFTWARE\Microsoft\NET Framework Setup\NDP\v3.0\Setup" "Version"
StrCmp $0 1 KnowNetFrameworkVersion +1
ReadRegDWORD $0 HKLM "SOFTWARE\Microsoft\NET Framework Setup\NDP\v2.0.50727" "Install"
ReadRegDWORD $1 HKLM "SOFTWARE\Microsoft\NET Framework Setup\NDP\v2.0.50727" "Version"
StrCmp $1 "" +1 +2
StrCpy $1 "2.0.50727.832"
StrCmp $0 1 KnowNetFrameworkVersion +1
ReadRegDWORD $0 HKLM "SOFTWARE\Microsoft\NET Framework Setup\NDP\v1.1.4322" "Install"
ReadRegDWORD $1 HKLM "SOFTWARE\Microsoft\NET Framework Setup\NDP\v1.1.4322" "Version"
StrCmp $1 "" +1 +2
StrCpy $1 "1.1.4322.573"
StrCmp $0 1 KnowNetFrameworkVersion +1
ReadRegDWORD $0 HKLM "SOFTWARE\Microsoft\.NETFramework\policy\v1.0" "Install"
ReadRegDWORD $1 HKLM "SOFTWARE\Microsoft\.NETFramework\policy\v1.0" "Version"
StrCmp $1 "" +1 +2
StrCpy $1 "1.0.3705.0"
StrCmp $0 1 KnowNetFrameworkVersion +1
StrCpy $1 "not .NetFramework"
KnowNetFrameworkVersion:
Pop $0
Exch $1
FunctionEnd
;----------安装 .NET Framework 2.0 -------------
Section -.NET
Call GetNetFrameworkVersion
Pop $R1
  ${If} $R1 < '1.9.0.0'
  DetailPrint "正在安装 .NET Framework 2.0 ..."
  SetDetailsPrint listonly

  SetOutPath "$TEMP"
  SetOverwrite on
  File "dotnetfx.exe"
  ExecWait '$TEMP\dotnetfx.exe' $R1
  Delete "$TEMP\dotnetfx.exe"
  ${EndIf}

  DetailPrint ".NET Framework 2.0安装完成 ..."
SectionEnd
;---------------开始加载打包资源文件目录---------------------
Section "SiteView8.2" SEC01
  SetOutPath "$INSTDIR"
  SetOverwrite ifnewer
  
  CreateDirectory "$SMPROGRAMS\SiteViewEcc8.2Client"

  DetailPrint "正在安装SiteView8.2Client主程序 ..."
  File /r Common
  File /r ECCClient
  File /r MmcSnapIn
  ExecWait '$INSTDIR\ECCClient\Install.bat'
  sleep 1000

  DetailPrint "安装SiteView8.2Client主程序安装完成 ..."
;---------------------创建桌面快捷方式-------------------

 DetailPrint "正在创建桌面快捷方式 ..."
 CreateShortCut "$DESKTOP\SiteViewECC8.2Client.lnk" "$INSTDIR\ECCClient\SiteViewECC.msc"
 CreateShortCut "$DESKTOP\SiteViewSolution.lnk" "$INSTDIR\ECCClient\SiteView.Solution.msc"
SectionEnd

;---------------------创建开始菜单快捷方式-------------------
Section -AdditionalIcons
  DetailPrint "正在创建开始菜单快捷方式 ..."
  CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2Client\SiteViewECC8.2Client.lnk" "$INSTDIR\ECCClient\SiteViewECC.msc"
  CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2Client\SiteViewSolution.lnk" "$INSTDIR\ECCClient\SiteView.Solution.msc"
  CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2Client\卸载SiteViewECC8.2Client.lnk" "$INSTDIR\uninstall.exe"

SectionEnd

Section -Post
  WriteUninstaller "$INSTDIR\uninstall.exe"
;-------------------------写入注册表--------------------------
  ;ExecWait 'Regedit.exe /s "$INSTDIR\data\svdb.reg"' ;导入外部注册表

   ;WriteRegStr HKLM "SOFTWARE\SiteView" "CommonDir" "$INSTDIR\common" ;common注册表路径
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "NetScan" "$INSTDIR\NetScan\ECCNetScanC.exe"
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "root_path_7" "$INSTDIR"
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installSVDB" "true"
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "version" "SiteView ECC 8.2"
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installMC" "true"

SectionEnd
;-------------------------软件卸载--------------------------
Function un.onUninstSuccess
  HideWindow
  MessageBox MB_ICONINFORMATION|MB_OK "$(^Name) 已成功地从你的计算机移除。"
FunctionEnd

Function un.onInit
  MessageBox MB_ICONQUESTION|MB_YESNO|MB_DEFBUTTON2 "你确实要完全移除 $(^Name) ，其及所有的组件？" IDYES +2
  Abort
FunctionEnd

;---------------卸载脚本开始 -------------------
Section Uninstall
  ExecWait '$INSTDIR\ECCClient\UnInstall.bat'
  sleep 1000
;---------------删除所有安装文件----------------

  Delete "$SMPROGRAMS\SiteViewEcc8.2Client\SiteViewECC8.2Client.lnk"
  Delete "$SMPROGRAMS\SiteViewEcc8.2Client\SiteViewSolution.lnk"
  Delete "$SMPROGRAMS\SiteViewEcc8.2Client\卸载SiteViewECC8.2Client.lnk"
  Delete "$DESKTOP\SiteViewECC8.2Client.lnk"
  Delete "$DESKTOP\SiteViewSolution.lnk"
  RMDir /r "$SMPROGRAMS\SiteViewEcc8.2Client\"
  RMDir /r "$INSTDIR\"

  ;DeleteRegKey HKLM "SOFTWARE\SiteView\SiteviewECC"
  ;DeleteRegKey HKLM "SOFTWARE\SiteView\"
  ;SetAutoClose true
SectionEnd
;---------------卸载脚本结束 -------------------