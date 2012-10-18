; Script created by zhngping.wang.

; HM NIS Edit Wizard helper defines
!define PRODUCT_NAME "���鲿����ϵͳ" ;��Ʒ����
!define PRODUCT_VERSION "8.1.3" ;��Ʒ�汾��
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
BrandingText "  �й�������֯�������ع���ϵͳ "
Name "${PRODUCT_NAME} ${PRODUCT_VERSION}"
OutFile "���鲿�����ع���ϵͳ��װ��.exe"
InstallDir "C:\SiteView\WebECC"
InstallDirRegKey HKLM "${PRODUCT_DIR_REGKEY}" ""
ShowInstDetails hide
ShowUninstDetails hide 
# ����ȫ��Ĭ��װ��ʽ
#SilentInstall silent
; ��ɺ��Զ��رհ�װ����
AutoCloseWindow true 
Section "SiteViewForZZB" SEC01
  SetOutPath "$INSTDIR"
  SetOverwrite ifnewer
  CreateDirectory "$SMPROGRAMS\���鲿����ϵͳ" #������ʼ�˵�������
;---------------�ͷ���Դ�ļ�---------------------------
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

 ;--------------����Windowsϵͳ����ʼ-------------------
#--------------����nsSCM�����װϵͳ����------------------
;nsSCM::Install - name -showname -type -starttype -dir -group -depend
DetailPrint "���ڰ�װϵͳ����......"
#--------------��װSiteViewDB����-------------------------
  nsSCM::Install /NOUNLOAD "SiteViewDB" "SiteView DB" 16 2 "$INSTDIR\fcgi-bin\svdb.exe -service" "" "" "" ""
#--------------��װSiteViewControl����--------------------
  nsSCM::Install /NOUNLOAD "SiteViewControl" "SiteView Monitor Control" 16 2 "$INSTDIR\fcgi-bin\MonitorContrl.exe -service" "" "SiteViewDB" "" ""
#--------------��װSiteViewReceive����--------------------
  Exec '"$INSTDIR\fcgi-bin\installReceiveSer.bat" $INSTDIR\fcgi-bin\SiteViewReceive.exe'
#---------------����siteviewssl.key��C�̸�Ŀ¼----------  
  CopyFiles $INSTDIR\WebECC8.1.3\Tomcat6\siteviewssl.key C:\siteviewssl.key
#---------------��װSiteViewEcc813WEB����-----------------
  ExecWait '$INSTDIR/WebECC8.1.3/install.bat'
#---------------��װDataTransferService����-----------------
  ExecWait '$INSTDIR/WebECC8.1.3/Tomcat6/bin/InstallDTService.bat'
  #---------------��װTomcat Monitor Service����-----------------
  ExecWait '$INSTDIR/WebECC8.1.3/Tomcat6/bin/InstallMonitorService.bat'
#--------------����Windowsϵͳ�������--------------------
  sleep 3000
#---------------ע��DLL-----------------------------------  
DetailPrint "����ע��ϵͳ���......"
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\fcgi-bin\Dragonflow.dll'
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\fcgi-bin\prj_WMI.dll'
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\SmSend.dll'
  Exec '"$INSTDIR\fcgi-bin\installDll.bat" $INSTDIR\ExchangeWmi.dll'

SectionEnd

Section -AdditionalIcons
  CreateShortCut "$SMPROGRAMS\���鲿����ϵͳ\��������ϵͳ����.lnk" "$INSTDIR\WebECC8.1.3\startAllService.bat"
  CreateShortCut "$SMPROGRAMS\���鲿����ϵͳ\ֹͣ����ϵͳ����.lnk" "$INSTDIR\WebECC8.1.3\stopAllService.bat"
  CreateShortCut "$SMPROGRAMS\���鲿����ϵͳ\ж�����鲿����ϵͳ.lnk" "$INSTDIR\uninst.exe"
  #WriteIniStr "$DESKTOP\���鲿����ϵͳ.url" "InternetShortcut" "URL" #"http://localhost:8181/ecc/index.jsp"
SectionEnd

Section -Post
  WriteUninstaller "$INSTDIR\uninst.exe"
;-------------------------д��ע���-------------------------------------
  ;ExecWait 'Regedit.exe /s "$INSTDIR\data\svdb.reg"' ;�����ⲿע���
   WriteRegStr HKLM "SOFTWARE\SiteView" "CommonDir" "$INSTDIR\common"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "NetScan" "$INSTDIR\NetScan\ECCNetScanC.exe"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "root_path_7" "$INSTDIR"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installSVDB" "true"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "version" "SiteView ECC 8.1.3"
   WriteRegStr HKLM "SOFTWARE\SiteView\SiteviewECC" "installMC" "true"
   
   
  ;--------------��ʼ�����Ѿ���װ�õķ���----------
  DetailPrint "��������ϵͳ����......"
  ExecWait '$INSTDIR\WebECC8.1.3\startAllService.bat'
SectionEnd
  
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
  DetailPrint "����ֹͣϵͳ����......"
  ExecWait '$INSTDIR\WebECC8.1.3\stopAllService.bat'
  sleep 2000
;---------------ɾ�����з���--------------------
  nsSCM::Remove /NOUNLOAD "SiteViewDB"
  nsSCM::Remove /NOUNLOAD "SiteViewControl"
  nsSCM::Remove /NOUNLOAD "SiteViewReceive"
  nsSCM::Remove /NOUNLOAD "SiteViewEcc813WEB"
  nsSCM::Remove /NOUNLOAD "DataTransferService"
  nsSCM::Remove /NOUNLOAD "TomcatMonitorService"
  sleep 1000
;---------------ɾ�����а�װ�ļ�----------------

  Delete "$INSTDIR\${PRODUCT_NAME}.url"
  Delete "$SMPROGRAMS\���鲿����ϵͳ\ж�����鲿����ϵͳ.lnk"
  Delete "$DESKTOP\���鲿����ϵͳ.url"
  Delete "$SMPROGRAMS\���鲿����ϵͳ\���鲿����ϵͳ.lnk"
  RMDir /r "$SMPROGRAMS\���鲿����ϵͳ\"
  RMDir /r "$INSTDIR\"
  DeleteRegKey HKLM "SOFTWARE\SiteView\SiteviewECC"
  DeleteRegKey HKLM "SOFTWARE\SiteView\"
  SetAutoClose true
SectionEnd
;---------------ж�ؽű����� -------------------