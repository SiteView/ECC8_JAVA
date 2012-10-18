package org.ofbiz.service.rmi;

import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Method;
import java.rmi.MarshalException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import java.rmi.UnmarshalException;
import java.rmi.server.Operation;
import java.rmi.server.RemoteCall;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteRef;
import java.rmi.server.RemoteStub;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;
import org.ofbiz.service.GenericRequester;
import org.ofbiz.service.GenericResultWaiter;
import org.ofbiz.service.GenericServiceException;

public final class RemoteDispatcherImpl_Stub extends RemoteStub
  implements RemoteDispatcher, Remote
{
  private static final Operation[] operations = { new Operation("void runAsync(java.lang.String, java.util.Map)"), new Operation("void runAsync(java.lang.String, java.util.Map, org.ofbiz.service.GenericRequester)"), new Operation("void runAsync(java.lang.String, java.util.Map, org.ofbiz.service.GenericRequester, boolean)"), new Operation("void runAsync(java.lang.String, java.util.Map, org.ofbiz.service.GenericRequester, boolean, int, boolean)"), new Operation("void runAsync(java.lang.String, java.util.Map, boolean)"), new Operation("org.ofbiz.service.GenericResultWaiter runAsyncWait(java.lang.String, java.util.Map)"), new Operation("org.ofbiz.service.GenericResultWaiter runAsyncWait(java.lang.String, java.util.Map, boolean)"), new Operation("java.util.Map runSync(java.lang.String, java.util.Map)"), new Operation("java.util.Map runSync(java.lang.String, java.util.Map, int, boolean)"), new Operation("void runSyncIgnore(java.lang.String, java.util.Map)"), new Operation("void runSyncIgnore(java.lang.String, java.util.Map, int, boolean)"), new Operation("void schedule(java.lang.String, java.util.Map, long)"), new Operation("void schedule(java.lang.String, java.util.Map, long, int, int, int)"), new Operation("void schedule(java.lang.String, java.util.Map, long, int, int, int, long)"), new Operation("void schedule(java.lang.String, java.util.Map, long, int, int, long)") };
  private static final long interfaceHash = 5658062257718870582L;
  private static final long serialVersionUID = 2L;
  private static boolean useNewInvoke;
  private static Method $method_runAsync_0;
  private static Method $method_runAsync_1;
  private static Method $method_runAsync_2;
  private static Method $method_runAsync_3;
  private static Method $method_runAsync_4;
  private static Method $method_runAsyncWait_5;
  private static Method $method_runAsyncWait_6;
  private static Method $method_runSync_7;
  private static Method $method_runSync_8;
  private static Method $method_runSyncIgnore_9;
  private static Method $method_runSyncIgnore_10;
  private static Method $method_schedule_11;
  private static Method $method_schedule_12;
  private static Method $method_schedule_13;
  private static Method $method_schedule_14;
  static Class array$Ljava$lang$Object;

  // ERROR //
  static
  {
    // Byte code:
    //   0: bipush 15
    //   2: anewarray 53	java/rmi/server/Operation
    //   5: dup
    //   6: iconst_0
    //   7: new 53	java/rmi/server/Operation
    //   10: dup
    //   11: ldc 22
    //   13: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: new 53	java/rmi/server/Operation
    //   22: dup
    //   23: ldc 24
    //   25: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: new 53	java/rmi/server/Operation
    //   34: dup
    //   35: ldc 25
    //   37: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   40: aastore
    //   41: dup
    //   42: iconst_3
    //   43: new 53	java/rmi/server/Operation
    //   46: dup
    //   47: ldc 26
    //   49: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   52: aastore
    //   53: dup
    //   54: iconst_4
    //   55: new 53	java/rmi/server/Operation
    //   58: dup
    //   59: ldc 23
    //   61: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   64: aastore
    //   65: dup
    //   66: iconst_5
    //   67: new 53	java/rmi/server/Operation
    //   70: dup
    //   71: ldc 13
    //   73: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   76: aastore
    //   77: dup
    //   78: bipush 6
    //   80: new 53	java/rmi/server/Operation
    //   83: dup
    //   84: ldc 14
    //   86: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   89: aastore
    //   90: dup
    //   91: bipush 7
    //   93: new 53	java/rmi/server/Operation
    //   96: dup
    //   97: ldc 10
    //   99: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   102: aastore
    //   103: dup
    //   104: bipush 8
    //   106: new 53	java/rmi/server/Operation
    //   109: dup
    //   110: ldc 11
    //   112: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   115: aastore
    //   116: dup
    //   117: bipush 9
    //   119: new 53	java/rmi/server/Operation
    //   122: dup
    //   123: ldc 27
    //   125: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   128: aastore
    //   129: dup
    //   130: bipush 10
    //   132: new 53	java/rmi/server/Operation
    //   135: dup
    //   136: ldc 28
    //   138: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   141: aastore
    //   142: dup
    //   143: bipush 11
    //   145: new 53	java/rmi/server/Operation
    //   148: dup
    //   149: ldc 29
    //   151: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   154: aastore
    //   155: dup
    //   156: bipush 12
    //   158: new 53	java/rmi/server/Operation
    //   161: dup
    //   162: ldc 30
    //   164: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   167: aastore
    //   168: dup
    //   169: bipush 13
    //   171: new 53	java/rmi/server/Operation
    //   174: dup
    //   175: ldc 31
    //   177: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   180: aastore
    //   181: dup
    //   182: bipush 14
    //   184: new 53	java/rmi/server/Operation
    //   187: dup
    //   188: ldc 32
    //   190: invokespecial 82	java/rmi/server/Operation:<init>	(Ljava/lang/String;)V
    //   193: aastore
    //   194: putstatic 110	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:operations	[Ljava/rmi/server/Operation;
    //   197: getstatic 97	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$rmi$server$RemoteRef	Ljava/lang/Class;
    //   200: ifnull +9 -> 209
    //   203: getstatic 97	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$rmi$server$RemoteRef	Ljava/lang/Class;
    //   206: goto +12 -> 218
    //   209: ldc 8
    //   211: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   214: dup
    //   215: putstatic 97	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$rmi$server$RemoteRef	Ljava/lang/Class;
    //   218: ldc 4
    //   220: iconst_4
    //   221: anewarray 38	java/lang/Class
    //   224: dup
    //   225: iconst_0
    //   226: getstatic 96	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$rmi$Remote	Ljava/lang/Class;
    //   229: ifnull +9 -> 238
    //   232: getstatic 96	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$rmi$Remote	Ljava/lang/Class;
    //   235: goto +12 -> 247
    //   238: ldc 7
    //   240: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   243: dup
    //   244: putstatic 96	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$rmi$Remote	Ljava/lang/Class;
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: getstatic 95	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$reflect$Method	Ljava/lang/Class;
    //   253: ifnull +9 -> 262
    //   256: getstatic 95	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$reflect$Method	Ljava/lang/Class;
    //   259: goto +12 -> 271
    //   262: ldc 6
    //   264: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   267: dup
    //   268: putstatic 95	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$reflect$Method	Ljava/lang/Class;
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: getstatic 92	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:array$Ljava$lang$Object	Ljava/lang/Class;
    //   277: ifnull +9 -> 286
    //   280: getstatic 92	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:array$Ljava$lang$Object	Ljava/lang/Class;
    //   283: goto +12 -> 295
    //   286: ldc 1
    //   288: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   291: dup
    //   292: putstatic 92	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:array$Ljava$lang$Object	Ljava/lang/Class;
    //   295: aastore
    //   296: dup
    //   297: iconst_3
    //   298: getstatic 91	java/lang/Long:TYPE	Ljava/lang/Class;
    //   301: aastore
    //   302: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   305: pop
    //   306: iconst_1
    //   307: putstatic 113	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:useNewInvoke	Z
    //   310: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   313: ifnull +9 -> 322
    //   316: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   319: goto +12 -> 331
    //   322: ldc 15
    //   324: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   327: dup
    //   328: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   331: ldc 16
    //   333: iconst_2
    //   334: anewarray 38	java/lang/Class
    //   337: dup
    //   338: iconst_0
    //   339: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   342: ifnull +9 -> 351
    //   345: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   348: goto +12 -> 360
    //   351: ldc 5
    //   353: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   356: dup
    //   357: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   360: aastore
    //   361: dup
    //   362: iconst_1
    //   363: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   366: ifnull +9 -> 375
    //   369: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   372: goto +12 -> 384
    //   375: ldc 9
    //   377: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   380: dup
    //   381: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   384: aastore
    //   385: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   388: putstatic 65	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runAsync_0	Ljava/lang/reflect/Method;
    //   391: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   394: ifnull +9 -> 403
    //   397: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   400: goto +12 -> 412
    //   403: ldc 15
    //   405: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   408: dup
    //   409: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   412: ldc 16
    //   414: iconst_3
    //   415: anewarray 38	java/lang/Class
    //   418: dup
    //   419: iconst_0
    //   420: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   423: ifnull +9 -> 432
    //   426: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   429: goto +12 -> 441
    //   432: ldc 5
    //   434: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   437: dup
    //   438: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   441: aastore
    //   442: dup
    //   443: iconst_1
    //   444: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   447: ifnull +9 -> 456
    //   450: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   453: goto +12 -> 465
    //   456: ldc 9
    //   458: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   461: dup
    //   462: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   465: aastore
    //   466: dup
    //   467: iconst_2
    //   468: getstatic 99	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$GenericRequester	Ljava/lang/Class;
    //   471: ifnull +9 -> 480
    //   474: getstatic 99	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$GenericRequester	Ljava/lang/Class;
    //   477: goto +12 -> 489
    //   480: ldc 12
    //   482: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   485: dup
    //   486: putstatic 99	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$GenericRequester	Ljava/lang/Class;
    //   489: aastore
    //   490: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   493: putstatic 66	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runAsync_1	Ljava/lang/reflect/Method;
    //   496: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   499: ifnull +9 -> 508
    //   502: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   505: goto +12 -> 517
    //   508: ldc 15
    //   510: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   513: dup
    //   514: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   517: ldc 16
    //   519: iconst_4
    //   520: anewarray 38	java/lang/Class
    //   523: dup
    //   524: iconst_0
    //   525: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   528: ifnull +9 -> 537
    //   531: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   534: goto +12 -> 546
    //   537: ldc 5
    //   539: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   542: dup
    //   543: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   546: aastore
    //   547: dup
    //   548: iconst_1
    //   549: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   552: ifnull +9 -> 561
    //   555: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   558: goto +12 -> 570
    //   561: ldc 9
    //   563: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   566: dup
    //   567: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   570: aastore
    //   571: dup
    //   572: iconst_2
    //   573: getstatic 99	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$GenericRequester	Ljava/lang/Class;
    //   576: ifnull +9 -> 585
    //   579: getstatic 99	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$GenericRequester	Ljava/lang/Class;
    //   582: goto +12 -> 594
    //   585: ldc 12
    //   587: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   590: dup
    //   591: putstatic 99	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$GenericRequester	Ljava/lang/Class;
    //   594: aastore
    //   595: dup
    //   596: iconst_3
    //   597: getstatic 89	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   600: aastore
    //   601: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   604: putstatic 67	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runAsync_2	Ljava/lang/reflect/Method;
    //   607: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   610: ifnull +9 -> 619
    //   613: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   616: goto +12 -> 628
    //   619: ldc 15
    //   621: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   624: dup
    //   625: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   628: ldc 16
    //   630: bipush 6
    //   632: anewarray 38	java/lang/Class
    //   635: dup
    //   636: iconst_0
    //   637: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   640: ifnull +9 -> 649
    //   643: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   646: goto +12 -> 658
    //   649: ldc 5
    //   651: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   654: dup
    //   655: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   658: aastore
    //   659: dup
    //   660: iconst_1
    //   661: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   664: ifnull +9 -> 673
    //   667: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   670: goto +12 -> 682
    //   673: ldc 9
    //   675: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   678: dup
    //   679: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   682: aastore
    //   683: dup
    //   684: iconst_2
    //   685: getstatic 99	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$GenericRequester	Ljava/lang/Class;
    //   688: ifnull +9 -> 697
    //   691: getstatic 99	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$GenericRequester	Ljava/lang/Class;
    //   694: goto +12 -> 706
    //   697: ldc 12
    //   699: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   702: dup
    //   703: putstatic 99	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$GenericRequester	Ljava/lang/Class;
    //   706: aastore
    //   707: dup
    //   708: iconst_3
    //   709: getstatic 89	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   712: aastore
    //   713: dup
    //   714: iconst_4
    //   715: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   718: aastore
    //   719: dup
    //   720: iconst_5
    //   721: getstatic 89	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   724: aastore
    //   725: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   728: putstatic 68	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runAsync_3	Ljava/lang/reflect/Method;
    //   731: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   734: ifnull +9 -> 743
    //   737: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   740: goto +12 -> 752
    //   743: ldc 15
    //   745: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   748: dup
    //   749: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   752: ldc 16
    //   754: iconst_3
    //   755: anewarray 38	java/lang/Class
    //   758: dup
    //   759: iconst_0
    //   760: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   763: ifnull +9 -> 772
    //   766: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   769: goto +12 -> 781
    //   772: ldc 5
    //   774: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   777: dup
    //   778: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   781: aastore
    //   782: dup
    //   783: iconst_1
    //   784: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   787: ifnull +9 -> 796
    //   790: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   793: goto +12 -> 805
    //   796: ldc 9
    //   798: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   801: dup
    //   802: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   805: aastore
    //   806: dup
    //   807: iconst_2
    //   808: getstatic 89	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   811: aastore
    //   812: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   815: putstatic 69	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runAsync_4	Ljava/lang/reflect/Method;
    //   818: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   821: ifnull +9 -> 830
    //   824: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   827: goto +12 -> 839
    //   830: ldc 15
    //   832: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   835: dup
    //   836: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   839: ldc 17
    //   841: iconst_2
    //   842: anewarray 38	java/lang/Class
    //   845: dup
    //   846: iconst_0
    //   847: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   850: ifnull +9 -> 859
    //   853: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   856: goto +12 -> 868
    //   859: ldc 5
    //   861: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   864: dup
    //   865: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   868: aastore
    //   869: dup
    //   870: iconst_1
    //   871: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   874: ifnull +9 -> 883
    //   877: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   880: goto +12 -> 892
    //   883: ldc 9
    //   885: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   888: dup
    //   889: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   892: aastore
    //   893: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   896: putstatic 63	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runAsyncWait_5	Ljava/lang/reflect/Method;
    //   899: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   902: ifnull +9 -> 911
    //   905: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   908: goto +12 -> 920
    //   911: ldc 15
    //   913: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   916: dup
    //   917: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   920: ldc 17
    //   922: iconst_3
    //   923: anewarray 38	java/lang/Class
    //   926: dup
    //   927: iconst_0
    //   928: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   931: ifnull +9 -> 940
    //   934: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   937: goto +12 -> 949
    //   940: ldc 5
    //   942: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   945: dup
    //   946: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   949: aastore
    //   950: dup
    //   951: iconst_1
    //   952: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   955: ifnull +9 -> 964
    //   958: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   961: goto +12 -> 973
    //   964: ldc 9
    //   966: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   969: dup
    //   970: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   973: aastore
    //   974: dup
    //   975: iconst_2
    //   976: getstatic 89	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   979: aastore
    //   980: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   983: putstatic 64	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runAsyncWait_6	Ljava/lang/reflect/Method;
    //   986: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   989: ifnull +9 -> 998
    //   992: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   995: goto +12 -> 1007
    //   998: ldc 15
    //   1000: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1003: dup
    //   1004: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1007: ldc 18
    //   1009: iconst_2
    //   1010: anewarray 38	java/lang/Class
    //   1013: dup
    //   1014: iconst_0
    //   1015: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1018: ifnull +9 -> 1027
    //   1021: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1024: goto +12 -> 1036
    //   1027: ldc 5
    //   1029: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1032: dup
    //   1033: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1036: aastore
    //   1037: dup
    //   1038: iconst_1
    //   1039: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1042: ifnull +9 -> 1051
    //   1045: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1048: goto +12 -> 1060
    //   1051: ldc 9
    //   1053: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1056: dup
    //   1057: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1060: aastore
    //   1061: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1064: putstatic 72	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runSync_7	Ljava/lang/reflect/Method;
    //   1067: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1070: ifnull +9 -> 1079
    //   1073: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1076: goto +12 -> 1088
    //   1079: ldc 15
    //   1081: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1084: dup
    //   1085: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1088: ldc 18
    //   1090: iconst_4
    //   1091: anewarray 38	java/lang/Class
    //   1094: dup
    //   1095: iconst_0
    //   1096: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1099: ifnull +9 -> 1108
    //   1102: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1105: goto +12 -> 1117
    //   1108: ldc 5
    //   1110: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1113: dup
    //   1114: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1117: aastore
    //   1118: dup
    //   1119: iconst_1
    //   1120: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1123: ifnull +9 -> 1132
    //   1126: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1129: goto +12 -> 1141
    //   1132: ldc 9
    //   1134: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1137: dup
    //   1138: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1141: aastore
    //   1142: dup
    //   1143: iconst_2
    //   1144: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1147: aastore
    //   1148: dup
    //   1149: iconst_3
    //   1150: getstatic 89	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   1153: aastore
    //   1154: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1157: putstatic 73	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runSync_8	Ljava/lang/reflect/Method;
    //   1160: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1163: ifnull +9 -> 1172
    //   1166: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1169: goto +12 -> 1181
    //   1172: ldc 15
    //   1174: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1177: dup
    //   1178: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1181: ldc 19
    //   1183: iconst_2
    //   1184: anewarray 38	java/lang/Class
    //   1187: dup
    //   1188: iconst_0
    //   1189: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1192: ifnull +9 -> 1201
    //   1195: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1198: goto +12 -> 1210
    //   1201: ldc 5
    //   1203: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1206: dup
    //   1207: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1210: aastore
    //   1211: dup
    //   1212: iconst_1
    //   1213: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1216: ifnull +9 -> 1225
    //   1219: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1222: goto +12 -> 1234
    //   1225: ldc 9
    //   1227: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1230: dup
    //   1231: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1234: aastore
    //   1235: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1238: putstatic 71	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runSyncIgnore_9	Ljava/lang/reflect/Method;
    //   1241: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1244: ifnull +9 -> 1253
    //   1247: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1250: goto +12 -> 1262
    //   1253: ldc 15
    //   1255: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1258: dup
    //   1259: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1262: ldc 19
    //   1264: iconst_4
    //   1265: anewarray 38	java/lang/Class
    //   1268: dup
    //   1269: iconst_0
    //   1270: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1273: ifnull +9 -> 1282
    //   1276: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1279: goto +12 -> 1291
    //   1282: ldc 5
    //   1284: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1287: dup
    //   1288: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1291: aastore
    //   1292: dup
    //   1293: iconst_1
    //   1294: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1297: ifnull +9 -> 1306
    //   1300: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1303: goto +12 -> 1315
    //   1306: ldc 9
    //   1308: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1311: dup
    //   1312: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1315: aastore
    //   1316: dup
    //   1317: iconst_2
    //   1318: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1321: aastore
    //   1322: dup
    //   1323: iconst_3
    //   1324: getstatic 89	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   1327: aastore
    //   1328: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1331: putstatic 70	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_runSyncIgnore_10	Ljava/lang/reflect/Method;
    //   1334: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1337: ifnull +9 -> 1346
    //   1340: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1343: goto +12 -> 1355
    //   1346: ldc 15
    //   1348: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1351: dup
    //   1352: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1355: ldc 20
    //   1357: iconst_3
    //   1358: anewarray 38	java/lang/Class
    //   1361: dup
    //   1362: iconst_0
    //   1363: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1366: ifnull +9 -> 1375
    //   1369: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1372: goto +12 -> 1384
    //   1375: ldc 5
    //   1377: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1380: dup
    //   1381: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1384: aastore
    //   1385: dup
    //   1386: iconst_1
    //   1387: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1390: ifnull +9 -> 1399
    //   1393: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1396: goto +12 -> 1408
    //   1399: ldc 9
    //   1401: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1404: dup
    //   1405: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1408: aastore
    //   1409: dup
    //   1410: iconst_2
    //   1411: getstatic 91	java/lang/Long:TYPE	Ljava/lang/Class;
    //   1414: aastore
    //   1415: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1418: putstatic 74	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_schedule_11	Ljava/lang/reflect/Method;
    //   1421: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1424: ifnull +9 -> 1433
    //   1427: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1430: goto +12 -> 1442
    //   1433: ldc 15
    //   1435: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1438: dup
    //   1439: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1442: ldc 20
    //   1444: bipush 6
    //   1446: anewarray 38	java/lang/Class
    //   1449: dup
    //   1450: iconst_0
    //   1451: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1454: ifnull +9 -> 1463
    //   1457: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1460: goto +12 -> 1472
    //   1463: ldc 5
    //   1465: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1468: dup
    //   1469: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1472: aastore
    //   1473: dup
    //   1474: iconst_1
    //   1475: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1478: ifnull +9 -> 1487
    //   1481: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1484: goto +12 -> 1496
    //   1487: ldc 9
    //   1489: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1492: dup
    //   1493: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1496: aastore
    //   1497: dup
    //   1498: iconst_2
    //   1499: getstatic 91	java/lang/Long:TYPE	Ljava/lang/Class;
    //   1502: aastore
    //   1503: dup
    //   1504: iconst_3
    //   1505: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1508: aastore
    //   1509: dup
    //   1510: iconst_4
    //   1511: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1514: aastore
    //   1515: dup
    //   1516: iconst_5
    //   1517: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1520: aastore
    //   1521: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1524: putstatic 75	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_schedule_12	Ljava/lang/reflect/Method;
    //   1527: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1530: ifnull +9 -> 1539
    //   1533: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1536: goto +12 -> 1548
    //   1539: ldc 15
    //   1541: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1544: dup
    //   1545: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1548: ldc 20
    //   1550: bipush 7
    //   1552: anewarray 38	java/lang/Class
    //   1555: dup
    //   1556: iconst_0
    //   1557: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1560: ifnull +9 -> 1569
    //   1563: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1566: goto +12 -> 1578
    //   1569: ldc 5
    //   1571: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1574: dup
    //   1575: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1578: aastore
    //   1579: dup
    //   1580: iconst_1
    //   1581: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1584: ifnull +9 -> 1593
    //   1587: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1590: goto +12 -> 1602
    //   1593: ldc 9
    //   1595: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1598: dup
    //   1599: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1602: aastore
    //   1603: dup
    //   1604: iconst_2
    //   1605: getstatic 91	java/lang/Long:TYPE	Ljava/lang/Class;
    //   1608: aastore
    //   1609: dup
    //   1610: iconst_3
    //   1611: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1614: aastore
    //   1615: dup
    //   1616: iconst_4
    //   1617: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1620: aastore
    //   1621: dup
    //   1622: iconst_5
    //   1623: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1626: aastore
    //   1627: dup
    //   1628: bipush 6
    //   1630: getstatic 91	java/lang/Long:TYPE	Ljava/lang/Class;
    //   1633: aastore
    //   1634: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1637: putstatic 76	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_schedule_13	Ljava/lang/reflect/Method;
    //   1640: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1643: ifnull +9 -> 1652
    //   1646: getstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1649: goto +12 -> 1661
    //   1652: ldc 15
    //   1654: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1657: dup
    //   1658: putstatic 100	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$org$ofbiz$service$rmi$RemoteDispatcher	Ljava/lang/Class;
    //   1661: ldc 20
    //   1663: bipush 6
    //   1665: anewarray 38	java/lang/Class
    //   1668: dup
    //   1669: iconst_0
    //   1670: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1673: ifnull +9 -> 1682
    //   1676: getstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1679: goto +12 -> 1691
    //   1682: ldc 5
    //   1684: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1687: dup
    //   1688: putstatic 94	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$lang$String	Ljava/lang/Class;
    //   1691: aastore
    //   1692: dup
    //   1693: iconst_1
    //   1694: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1697: ifnull +9 -> 1706
    //   1700: getstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1703: goto +12 -> 1715
    //   1706: ldc 9
    //   1708: invokestatic 93	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   1711: dup
    //   1712: putstatic 98	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:class$java$util$Map	Ljava/lang/Class;
    //   1715: aastore
    //   1716: dup
    //   1717: iconst_2
    //   1718: getstatic 91	java/lang/Long:TYPE	Ljava/lang/Class;
    //   1721: aastore
    //   1722: dup
    //   1723: iconst_3
    //   1724: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1727: aastore
    //   1728: dup
    //   1729: iconst_4
    //   1730: getstatic 90	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1733: aastore
    //   1734: dup
    //   1735: iconst_5
    //   1736: getstatic 91	java/lang/Long:TYPE	Ljava/lang/Class;
    //   1739: aastore
    //   1740: invokevirtual 105	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1743: putstatic 77	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:$method_schedule_14	Ljava/lang/reflect/Method;
    //   1746: goto +8 -> 1754
    //   1749: pop
    //   1750: iconst_0
    //   1751: putstatic 113	org/ofbiz/service/rmi/RemoteDispatcherImpl_Stub:useNewInvoke	Z
    //   1754: return
    //
    // Exception table:
    //   from	to	target	type
    //   197	1746	1749	java/lang/NoSuchMethodException
  }

  public RemoteDispatcherImpl_Stub()
  {
  }

  public RemoteDispatcherImpl_Stub(RemoteRef paramRemoteRef)
  {
    super(paramRemoteRef);
  }

  public void runAsync(String paramString, Map paramMap)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_runAsync_0, new Object[] { paramString, paramMap }, 7388701430291161509L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 0, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void runAsync(String paramString, Map paramMap, GenericRequester paramGenericRequester)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_runAsync_1, new Object[] { paramString, paramMap, paramGenericRequester }, 4461126433741467972L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 1, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
          localObjectOutput.writeObject(paramGenericRequester);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void runAsync(String paramString, Map paramMap, GenericRequester paramGenericRequester, boolean paramBoolean)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_runAsync_2, new Object[] { paramString, paramMap, paramGenericRequester, (paramBoolean) ? Boolean.TRUE : Boolean.FALSE }, -8254594307630171602L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 2, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
          localObjectOutput.writeObject(paramGenericRequester);
          localObjectOutput.writeBoolean(paramBoolean);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void runAsync(String paramString, Map paramMap, GenericRequester paramGenericRequester, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_runAsync_3, new Object[] { paramString, paramMap, paramGenericRequester, (paramBoolean1) ? Boolean.TRUE : Boolean.FALSE, new Integer(paramInt), (paramBoolean2) ? Boolean.TRUE : Boolean.FALSE }, 7952886269633016064L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 3, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
          localObjectOutput.writeObject(paramGenericRequester);
          localObjectOutput.writeBoolean(paramBoolean1);
          localObjectOutput.writeInt(paramInt);
          localObjectOutput.writeBoolean(paramBoolean2);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void runAsync(String paramString, Map paramMap, boolean paramBoolean)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_runAsync_4, new Object[] { paramString, paramMap, (paramBoolean) ? Boolean.TRUE : Boolean.FALSE }, 3627120838063131527L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 4, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
          localObjectOutput.writeBoolean(paramBoolean);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public GenericResultWaiter runAsyncWait(String paramString, Map paramMap)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        Object localObject1 = this.ref.invoke(this, $method_runAsyncWait_5, new Object[] { paramString, paramMap }, 7465872921023252277L);
        return (GenericResultWaiter)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 5, 5658062257718870582L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramMap);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      GenericResultWaiter localGenericResultWaiter;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localGenericResultWaiter = (GenericResultWaiter)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localGenericResultWaiter;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public GenericResultWaiter runAsyncWait(String paramString, Map paramMap, boolean paramBoolean)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        Object localObject1 = this.ref.invoke(this, $method_runAsyncWait_6, new Object[] { paramString, paramMap, (paramBoolean) ? Boolean.TRUE : Boolean.FALSE }, 2852019610591249218L);
        return (GenericResultWaiter)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 6, 5658062257718870582L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramMap);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      GenericResultWaiter localGenericResultWaiter;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localGenericResultWaiter = (GenericResultWaiter)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localGenericResultWaiter;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public Map runSync(String paramString, Map paramMap)
    throws RemoteException, GenericServiceException
  {
	  long start =System.currentTimeMillis();
	  System.out.println("*********Remote call start at "+start+" ***********");
    try
    {
      if (useNewInvoke)
      {
        Object localObject1 = this.ref.invoke(this, $method_runSync_7, new Object[] { paramString, paramMap }, 3117439646154131779L);
        return (Map)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 7, 5658062257718870582L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramMap);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Map localMap;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localMap = (Map)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      long end =System.currentTimeMillis();
      System.out.println("*********Remote call end at "+end+" total "+ (end-start)+" ms ***********");
      return localMap;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public Map runSync(String paramString, Map paramMap, int paramInt, boolean paramBoolean)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        Object localObject1 = this.ref.invoke(this, $method_runSync_8, new Object[] { paramString, paramMap, new Integer(paramInt), (paramBoolean) ? Boolean.TRUE : Boolean.FALSE }, -3631901869379275227L);
        return (Map)localObject1;
      }
      Object localObject1 = this.ref.newCall(this, operations, 8, 5658062257718870582L);
      try
      {
        ObjectOutput localObjectOutput = ((RemoteCall)localObject1).getOutputStream();
        localObjectOutput.writeObject(paramString);
        localObjectOutput.writeObject(paramMap);
        localObjectOutput.writeInt(paramInt);
        localObjectOutput.writeBoolean(paramBoolean);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling arguments", localIOException1);
      }
      this.ref.invoke((RemoteCall)localObject1);
      Map localMap;
      try
      {
        ObjectInput localObjectInput = ((RemoteCall)localObject1).getInputStream();
        localMap = (Map)localObjectInput.readObject();
      }
      catch (IOException localIOException2)
      {
        throw new UnmarshalException("error unmarshalling return", localIOException2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new UnmarshalException("error unmarshalling return", localClassNotFoundException);
      }
      finally
      {
        this.ref.done((RemoteCall)localObject1);
      }
      return localMap;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void runSyncIgnore(String paramString, Map paramMap)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_runSyncIgnore_9, new Object[] { paramString, paramMap }, -5380780906253906391L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 9, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void runSyncIgnore(String paramString, Map paramMap, int paramInt, boolean paramBoolean)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_runSyncIgnore_10, new Object[] { paramString, paramMap, new Integer(paramInt), (paramBoolean) ? Boolean.TRUE : Boolean.FALSE }, 3055758260638559780L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 10, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
          localObjectOutput.writeInt(paramInt);
          localObjectOutput.writeBoolean(paramBoolean);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void schedule(String paramString, Map paramMap, long paramLong)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_schedule_11, new Object[] { paramString, paramMap, new Long(paramLong) }, 61220135417632594L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 11, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
          localObjectOutput.writeLong(paramLong);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void schedule(String paramString, Map paramMap, long paramLong, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_schedule_12, new Object[] { paramString, paramMap, new Long(paramLong), new Integer(paramInt1), new Integer(paramInt2), new Integer(paramInt3) }, -3162534681576044283L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 12, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
          localObjectOutput.writeLong(paramLong);
          localObjectOutput.writeInt(paramInt1);
          localObjectOutput.writeInt(paramInt2);
          localObjectOutput.writeInt(paramInt3);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void schedule(String paramString, Map paramMap, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_schedule_13, new Object[] { paramString, paramMap, new Long(paramLong1), new Integer(paramInt1), new Integer(paramInt2), new Integer(paramInt3), new Long(paramLong2) }, -214200713778138959L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 13, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
          localObjectOutput.writeLong(paramLong1);
          localObjectOutput.writeInt(paramInt1);
          localObjectOutput.writeInt(paramInt2);
          localObjectOutput.writeInt(paramInt3);
          localObjectOutput.writeLong(paramLong2);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }

  public void schedule(String paramString, Map paramMap, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
    throws RemoteException, GenericServiceException
  {
    try
    {
      if (useNewInvoke)
      {
        this.ref.invoke(this, $method_schedule_14, new Object[] { paramString, paramMap, new Long(paramLong1), new Integer(paramInt1), new Integer(paramInt2), new Long(paramLong2) }, 8014934600388704671L);
      }
      else
      {
        RemoteCall localRemoteCall = this.ref.newCall(this, operations, 14, 5658062257718870582L);
        try
        {
          ObjectOutput localObjectOutput = localRemoteCall.getOutputStream();
          localObjectOutput.writeObject(paramString);
          localObjectOutput.writeObject(paramMap);
          localObjectOutput.writeLong(paramLong1);
          localObjectOutput.writeInt(paramInt1);
          localObjectOutput.writeInt(paramInt2);
          localObjectOutput.writeLong(paramLong2);
        }
        catch (IOException localIOException)
        {
          throw new MarshalException("error marshalling arguments", localIOException);
        }
        this.ref.invoke(localRemoteCall);
        this.ref.done(localRemoteCall);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (GenericServiceException localGenericServiceException)
    {
      throw localGenericServiceException;
    }
    catch (Exception localException)
    {
      throw new UnexpectedException("undeclared checked exception", localException);
    }
  }
}

/* Location:           D:\core\dragonflow\siteview\ofbiz\framework\service\build\classes\
 * Qualified Name:     org.ofbiz.service.rmi.RemoteDispatcherImpl_Stub
 * JD-Core Version:    0.5.4
 */