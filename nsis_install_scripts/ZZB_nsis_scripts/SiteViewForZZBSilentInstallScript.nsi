; Script created by zhngping.wang.

; HM NIS Edit Wizard helper defines
!define PRODUCT_NAME "中组部网管系统" ;产品名称
!define PRODUCT_VERSION "8.1.3" ;产品版本号
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
#!define JAVA_HOME "$INSTDIR\WebECC8.1.3\jre1.6.0_04"
; Welcome page
;!insertmacro MUI_PAGE_WELCOME


; Directory page
;!insertmacro MUI_PAGE_DIRECTORY
; Instfiles page
;!insertmacro MUI_PAGE_INSTFILES
; Finish page
;!insertmacro MUI_PAGE_FINISH

; Uninstaller pages
!insertmacro MUI_UNPAGE_INSTFILES

; Language files
!insertmacro MUI_LANGUAGE "SimpChinese"

; MUI end ------
BrandingText "  中共中央组织部网络监控管理系统 "
Name "${PRODUCT_NAME} ${PRODUCT_VERSION}"
OutFile "中组部网络监控管理系统安装包.exe"
InstallDir "C:\SiteView\WebECC"
InstallDirRegKey HKLM "${PRODUCT_DIR_REGKEY}" ""
ShowInstDetails hide
ShowUninstDetails hide 
# 声明全静默安装方式
#SilentInstall silent
; 完成后自动关闭安装程序
AutoCloseWindow true 
Section "SiteViewForZZB" SEC01
  SetOutPath "$INSTDIR"
  SetOverwrite ifnewer
  CreateDirectory "$SMPROGRAMS\中组部网管系统" #创建开始菜单栏名称
;---------------释放资源文件---------------------------
SetDetailsPrint textonly
  File /r WebECC8.1.3
  File /r bin
  File /r cgi-bin
  File /r common
  File /r conf
  File /r data
  File /r english
  File /r fcgi-bin
  File /r logs
  File /r modules
  File /r smsplugin
  File /r temp
  File /r Tools
  File /r createtable.sql
SetDetailsPrint textonly 

 ;--------------创建Windows系统服务开始-------------------
#--------------引用nsSCM插件安装系统服务------------------
;nsSCM::Install - name -showname -type -starttype -dir -group -depend
DetailPrint "正在安装系统服务......"
#--------------安装SiteViewDB服务-------------------------
  nsSCM::Install /NOUNLOAD "SiteViewDB" "SiteView DB" 16 2 "$INSTDIR\fcgi-bin\svdb.exe -service" "" "" "" ""
#--------------安装SiteViewControl服务--------------------
  nsSCM::Install /NOUNLOAD "SiteViewControl" "SiteView Monitor Control" 16 2 "$INSTDIR\fcgi-bin\MonitorContrl.exe -service" "" "SiteViewDB" "" ""
#--------------安装SiteViewReceive服务--------------------
  Exec '"$INSTDIR\fcgi-bin\installReceiveSer.bat" $INSTDIR\fcgi-bin\SiteViewReceive.exe'
#---------------复制siteviewssl.key到C盘根目录----------  
  CopyFiles $INSTDIR\WebECC8.1.3\Tomcat6\siteviewssl.key C:\siteviewssl.key
#---------------安装SiteViewEcc813WEB服务-----------------
  ExecWait '$INSTDIR/WebECC8.1.3/install.bat'
#---------------安装DataTransferService服务-----------------
  ExecWait '$INSTDIR/WebECC8.1.3/Tomcat6/bin/InstallDTService.bat'
  #---------------安装Tomcat Monitor Service服务-----------------
  ExecWait '$INSTDIR/WebECC8.1.3/Tomcat6/bin/InstallMonitorService.bat'
#--------------创建Windows系统服务结束--------------------
  sleep 3000
#---------------注册DLL-----------------------------------  
DetailPrint "正在注册系统组件......"
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\fcgi-bin\Dragonflow.dll'
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\fcgi-bin\prj_WMI.dll'
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\SmSend.dll'
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\ExchangeWmi.dll'

SectionEnd

Section -AdditionalIcons
  CreateShortCut "$SMPROGRAMS\中组部网管系统\开启所有系统服务.lnk" "$INSTDIR\WebECC8.1.3\startAllService.bat"
  CreateShortCut "$SMPROGRAMS\中组部网管系统\停止所有系统服务.lnk" "$INSTDIR\WebECC8.1.3\stopAllService.bat"
  CreateShortCut "$SMPROGRAMS\中组部网管系统\卸载中组部网管系统.lnk" "$INSTDIR\uninst.exe"
  #WriteIniStr "$DESKTOP\中组部网管系统.url" "InternetShortcut" "URL" #"http://localhost:8181/ecc/index.jsp"
SectionEnd

Section -Post
  WriteUninstaller "$INSTDIR\uninst.exe"
;-------------------------写入注册表-------------------------------------
  ;ExecWait 'Regedit.exe /s "$INSTDIR\data\svdb.reg"' ;导入外部注册表
   WriteRegStr HKLM "SOFTWARE\SiteView" "CommonDir" "$INSTDIR\common"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "NetScan" "$INSTDIR\NetScan\ECCNetScanC.exe"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "root_path_7" "$INSTDIR"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installSVDB" "true"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "version" "SiteView ECC 8.1.3"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installMC" "true"
   
   
  ;--------------开始启动已经安装好的服务----------
  DetailPrint "正在启动系统服务......"
  ExecWait '$INSTDIR\WebECC8.1.3\startAllService.bat'
SectionEnd
  
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
;---------------停止所有服务--------------------
  DetailPrint "正在停止系统服务......"
  ExecWait '$INSTDIR\WebECC8.1.3\stopAllService.bat'
  sleep 2000
;---------------删除所有服务--------------------
  nsSCM::Remove /NOUNLOAD "SiteViewDB"
  nsSCM::Remove /NOUNLOAD "SiteViewControl"
  nsSCM::Remove /NOUNLOAD "SiteViewReceive"
  nsSCM::Remove /NOUNLOAD "SiteViewEcc813WEB"
  nsSCM::Remove /NOUNLOAD "DataTransferService"
  nsSCM::Remove /NOUNLOAD "TomcatMonitorService"
  sleep 1000
;---------------删除所有安装文件----------------

  Delete "$INSTDIR\${PRODUCT_NAME}.url"
  Delete "$SMPROGRAMS\中组部网管系统\卸载中组部网管系统.lnk"
  Delete "$DESKTOP\中组部网管系统.url"
  Delete "$SMPROGRAMS\中组部网管系统\中组部网管系统.lnk"
  RMDir /r "$SMPROGRAMS\中组部网管系统\"
  RMDir /r "$INSTDIR\"
  DeleteRegKey HKLM "SOFTWARE\SiteView\SiteviewECC"
  DeleteRegKey HKLM "SOFTWARE\SiteView\"
  SetAutoClose true
SectionEnd
;---------------卸载脚本结束 -------------------