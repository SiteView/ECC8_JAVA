; Script created by zhngping.wang.

; HM NIS Edit Wizard helper defines
!define PRODUCT_NAME "SiteViewEcc" ;��Ʒ����
!define PRODUCT_VERSION "8.2" ;��Ʒ�汾��
!define PRODUCT_PUBLISHER "DragonFlow, Inc." ;��Ʒ���й�˾
!define PRODUCT_WEB_SITE "http://www.siteview.com" ;��Ʒ���й�˾��ַ
!define PRODUCT_UNINST_KEY "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}"


; MUI 1.67 compatible ------
!include "MUI.nsh" ;������ʽ�û�����

;Register Environmnet Variable
!include AddPath.nsh ;�����Զ���ű�
!include WriteEnvStr.nsh
!define JAVA_HOME "$INSTDIR\jre1.6.0_04"

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
BrandingText "  Copyright 2000-2012 DragonFlow, Inc.  All Rights Reserved. "
Name "${PRODUCT_NAME} ${PRODUCT_VERSION}"
OutFile "SiteView8.2��׼��.exe"
InstallDir "C:\SiteView\SiteViewEcc8.2"
InstallDirRegKey HKLM "${PRODUCT_DIR_REGKEY}" ""
ShowInstDetails show
ShowUnInstDetails show

Section "SiteView8.2" SEC01
  SetOutPath "$INSTDIR"
  SetOverwrite ifnewer
  
  CreateDirectory "$SMPROGRAMS\SiteViewEcc8.2"
;---------------��ʼ���ش����Դ�ļ�Ŀ¼---------------------
  File /r fcgi-bin
  File /r common
  File /r modules
  File /r ofbiz
  File /r smsplugin
  File /r data
  File /r Tools
  File /r english
  File /r ejabberd-2.1.9
  ;��Ĭ��װejabberd
  ;DetailPrint "Installing ejabberd xmpp server"
  ;ExecWait '"$INSTDIR\thirdparty\ejabberd-2.1.9-windows-installer.exe"  --unattendedmodeui minimal --adminpw admin  --installer-language zh_CN --ejabberddomain localhost --mode unattended --hostname localhost'
  ;---���ejabber�û�
  ;DetailPrint "������Ϣ���񹤾ߡ���"
  ;ExecWait '"$INSTDIR\thirdparty\createuser32.bat"'
;---------------���ش����Դ�ļ�Ŀ¼���� -------------------
;--------------����Windowsϵͳ����ʼ----------
;--------------����nsSCM���--------------------
;nsSCM::Install - name -showname -type -starttype -dir -group -depend
;--------------��װSiteViewDB����---------------------
  nsSCM::Install /NOUNLOAD "SiteViewDB" "SiteView DB" 16 2 "$INSTDIR\fcgi-bin\svdb.exe -service" "" "" "" ""
;--------------��װSiteViewControl����---------------------
  nsSCM::Install /NOUNLOAD "SiteViewControl" "SiteView Monitor Control" 16 2 "$INSTDIR\fcgi-bin\MonitorContrl.exe -service" "" "SiteViewDB" "" ""
#--------------��װSiteViewReceive����--------------------
  Exec '"$INSTDIR\fcgi-bin\installReceiveSer.bat" $INSTDIR\fcgi-bin\SiteViewReceive.exe'

  ExecWait '$INSTDIR\ofbiz\win32\InstallOFBIZ.bat'
  sleep 1000
;--------------����Windowsϵͳ�������--------------------
#---------------ע��DLL-----------------------------------  
DetailPrint "����ע��ϵͳ���......"
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\fcgi-bin\Dragonflow.dll'
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\fcgi-bin\prj_WMI.dll'
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\SmSend.dll'
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\ExchangeWmi.dll'
;--------------��ʼ���û�������---------------------------
SetOutPath "$INSTDIR"
  SetOverwrite try
  File /r jre1.6.0_04
  Push JAVA_HOME
  Push '${JAVA_HOME}'
  Call WriteEnvStr
  Push '${JAVA_HOME}\bin'
  Call AddToPath

  ;CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2\SiteViewEcc8.2.lnk" "$INSTDIR\fcgi-bin\svdb.exe"
  ;CreateShortCut "$DESKTOP\SiteViewEcc8.2.lnk" "$INSTDIR\fcgi-bin\svdb.exe"
SectionEnd

Section -AdditionalIcons
  CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2\ж��SiteViewEcc8.2.lnk" "$INSTDIR\uninst.exe"
  CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2\������Ϣ������.lnk" "$INSTDIR\ejabberd-2.1.9\bin\start.cmd"
  CreateShortCut "$SMPROGRAMS\SiteViewEcc8.2\�ر���Ϣ������.lnk" "$INSTDIR\ejabberd-2.1.9\bin\stop.cmd"
  WriteIniStr "$DESKTOP\SiteView8.2.url" "InternetShortcut" "URL" "http://localhost:8181/ecc/index.jsp"
SectionEnd

Section -Post
  WriteUninstaller "$INSTDIR\uninst.exe"
;-------------------------д��ע���-------------------------------------
  ;ExecWait 'Regedit.exe /s "$INSTDIR\data\svdb.reg"' ;�����ⲿע���

   WriteRegStr HKLM "SOFTWARE\SiteView" "CommonDir" "$INSTDIR\common" ;commonע���·��
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "NetScan" "$INSTDIR\NetScan\ECCNetScanC.exe"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "root_path_7" "$INSTDIR"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installSVDB" "true"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "version" "SiteView ECC 8.2"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installMC" "true"
   
   WriteRegStr HKLM "SOFTWARE\ProcessOne\ejabberd" "Location" "$INSTDIR\ejabberd-2.1.9"
   WriteRegStr HKLM "SOFTWARE\ProcessOne\ejabberd" "Version" "2.1.9"
   
  ;--------------��ʼ�����Ѿ���װ�õķ���----------
  ExecWait '$INSTDIR\ejabberd-2.1.9\bin\start.cmd'
  nsSCM::Start /NOUNLOAD "SiteViewDB"
  sleep 2000
  nsSCM::Start /NOUNLOAD "SiteViewControl"
  sleep 2000
  nsSCM::Start /NOUNLOAD "SiteViewReceive"
  nsSCM::Start /NOUNLOAD "SiteViewOfbizService"
SectionEnd
Function un.removeEnvPath
  Push JAVA_HOME
  Call un.DeleteEnvStr
  Push ${JAVA_HOME}\bin
  Call un.RemoveFromPath
FunctionEnd

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
;---------------ֹͣ���з���--------------------
 ExecWait '$INSTDIR\ejabberd-2.1.9\bin\stop.cmd'
  nsSCM::Stop /NOUNLOAD "SiteViewDB"
  nsSCM::Stop /NOUNLOAD "SiteViewControl"
  nsSCM::Stop /NOUNLOAD "SiteViewReceive"
  nsSCM::Stop /NOUNLOAD "EjabberdService"
;---------------ɾ�����з���--------------------
  nsSCM::Remove /NOUNLOAD "SiteViewDB"
  nsSCM::Remove /NOUNLOAD "SiteViewControl"
  ;nsSCM::Remove /NOUNLOAD "SiteViewReceive"
  ExecWait '$INSTDIR\ofbiz\win32\UninstallOFBIZ.bat'
  sleep 1000
;---------------ɾ�����а�װ�ļ�----------------

  Delete "$INSTDIR\${PRODUCT_NAME}.url"
  Delete "$SMPROGRAMS\SiteViewEcc8.2\Uninstall.lnk"
  Delete "$DESKTOP\SiteView8.2.url"
  Delete "$SMPROGRAMS\SiteViewEcc8.2\SiteViewEcc8.2.lnk"
  RMDir /r "$SMPROGRAMS\SiteViewEcc8.2\"
  RMDir /r "$INSTDIR\"
  Call un.removeEnvPath
  DeleteRegKey HKLM "SOFTWARE\SiteView\SiteviewECC"
  DeleteRegKey HKLM "SOFTWARE\SiteView\"
  DeleteRegKey HKLM "SOFTWARE\ProcessOne\ejabberd"
  DeleteRegKey HKLM "SOFTWARE\ProcessOne\"
  SetAutoClose true
SectionEnd
;---------------ж�ؽű����� -------------------