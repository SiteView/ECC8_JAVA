; Script created by zhngping.wang.

; HM NIS Edit Wizard helper defines
!define PRODUCT_NAME "SiteViewEccClient" ;��Ʒ����
!define PRODUCT_VERSION "8.2" ;��Ʒ�汾��
!define PRODUCT_PUBLISHER "DragonFlow, Inc." ;��Ʒ���й�˾
!define PRODUCT_WEB_SITE "http://www.siteview.com" ;��Ʒ���й�˾��ַ
!define PRODUCT_UNINST_KEY "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}"


; MUI 1.67 compatible ------
!include "MUI.nsh" ;������ʽ�û�����

;Register Environmnet Variable

; MUI Settings
!define MUI_ABORTWARNING
!define MUI_ICON "logo.ico"  ;���ͼ��
!define MUI_UNICON "unInstall.ico" ;ж��ͼ��

; Welcome page
!insertmacro MUI_PAGE_WELCOME
; License page
!define MUI_LICENSEPAGE_CHECKBOX
!insertmacro MUI_PAGE_LICENSE "siteviewlicense.rtf" ;��Ȩ�ļ�
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
;--------------��ȡ��װ�����е�.net�汾---------------
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
;----------��װ .NET Framework 2.0 -------------
Section -.NET
Call GetNetFrameworkVersion
Pop $R1
  ${If} $R1 < '1.9.0.0'
  DetailPrint "���ڰ�װ .NET Framework 2.0 ..."
  SetDetailsPrint listonly

  SetOutPath "$TEMP"
  SetOverwrite on
  File "dotnetfx.exe"
  ExecWait '$TEMP\dotnetfx.exe' $R1
  Delete "$TEMP\dotnetfx.exe"
  ${EndIf}

  DetailPrint ".NET Framework 2.0��װ��� ..."
SectionEnd
;---------------��ʼ���ش����Դ�ļ�Ŀ¼---------------------
Section "SiteView8.2" SEC01
  SetOutPath "$INSTDIR"
  SetOverwrite ifnewer
  
  CreateDirectory "$SMPROGRAMS\SiteViewEcc8.2Client"

  DetailPrint "���ڰ�װSiteView8.2Client������ ..."
  File /r Common
  File /r ECCClient
  File /r MmcSnapIn
  ExecWait '$INSTDIR\ECCClient\Install.bat'
  sleep 1000

  DetailPrint "��װSiteView8.2Client������װ��� ..."
;---------------------���������ݷ�ʽ-------------------

 DetailPrint "���ڴ��������ݷ�ʽ ..."
 CreateShortCut "$DESKTOP\SiteViewECC8.2Client.lnk" "$INSTDIR\ECCClient\SiteViewECC.msc"
 CreateShortCut "$DESKTOP\SiteViewSolution.lnk" "$INSTDIR\ECCClient\SiteView.Solution.msc"
SectionEnd

;---------------------������ʼ�˵���ݷ�ʽ-------------------
Section -AdditionalIcons
  DetailPrint "���ڴ�����ʼ�˵���ݷ�ʽ ..."
  CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2Client\SiteViewECC8.2Client.lnk" "$INSTDIR\ECCClient\SiteViewECC.msc"
  CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2Client\SiteViewSolution.lnk" "$INSTDIR\ECCClient\SiteView.Solution.msc"
  CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2Client\ж��SiteViewECC8.2Client.lnk" "$INSTDIR\uninstall.exe"

SectionEnd

Section -Post
  WriteUninstaller "$INSTDIR\uninstall.exe"
;-------------------------д��ע���--------------------------
  ;ExecWait 'Regedit.exe /s "$INSTDIR\data\svdb.reg"' ;�����ⲿע���

   ;WriteRegStr HKLM "SOFTWARE\SiteView" "CommonDir" "$INSTDIR\common" ;commonע���·��
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "NetScan" "$INSTDIR\NetScan\ECCNetScanC.exe"
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "root_path_7" "$INSTDIR"
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installSVDB" "true"
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "version" "SiteView ECC 8.2"
   ;WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installMC" "true"

SectionEnd
;-------------------------���ж��--------------------------
Function un.onUninstSuccess
  HideWindow
  MessageBox MB_ICONINFORMATION|MB_OK "$(^Name) �ѳɹ��ش���ļ�����Ƴ���"
FunctionEnd

Function un.onInit
  MessageBox MB_ICONQUESTION|MB_YESNO|MB_DEFBUTTON2 "��ȷʵҪ��ȫ�Ƴ� $(^Name) ���估���е������" IDYES +2
  Abort
FunctionEnd

;---------------ж�ؽű���ʼ -------------------
Section Uninstall
  ExecWait '$INSTDIR\ECCClient\UnInstall.bat'
  sleep 1000
;---------------ɾ�����а�װ�ļ�----------------

  Delete "$SMPROGRAMS\SiteViewEcc8.2Client\SiteViewECC8.2Client.lnk"
  Delete "$SMPROGRAMS\SiteViewEcc8.2Client\SiteViewSolution.lnk"
  Delete "$SMPROGRAMS\SiteViewEcc8.2Client\ж��SiteViewECC8.2Client.lnk"
  Delete "$DESKTOP\SiteViewECC8.2Client.lnk"
  Delete "$DESKTOP\SiteViewSolution.lnk"
  RMDir /r "$SMPROGRAMS\SiteViewEcc8.2Client\"
  RMDir /r "$INSTDIR\"

  ;DeleteRegKey HKLM "SOFTWARE\SiteView\SiteviewECC"
  ;DeleteRegKey HKLM "SOFTWARE\SiteView\"
  ;SetAutoClose true
SectionEnd
;---------------ж�ؽű����� -------------------