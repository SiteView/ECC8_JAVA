package org.ofbiz.service.rmi;

import java.io.DataInput;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.rmi.MarshalException;
import java.rmi.Remote;
import java.rmi.UnmarshalException;
import java.rmi.server.Operation;
import java.rmi.server.RemoteCall;
import java.rmi.server.Skeleton;
import java.rmi.server.SkeletonMismatchException;
import java.util.Map;
import org.ofbiz.service.GenericRequester;
import org.ofbiz.service.GenericResultWaiter;

public final class RemoteDispatcherImpl_Skel
  implements Skeleton
{
  private static final Operation[] operations = { new Operation("void runAsync(java.lang.String, java.util.Map)"), new Operation("void runAsync(java.lang.String, java.util.Map, org.ofbiz.service.GenericRequester)"), new Operation("void runAsync(java.lang.String, java.util.Map, org.ofbiz.service.GenericRequester, boolean)"), new Operation("void runAsync(java.lang.String, java.util.Map, org.ofbiz.service.GenericRequester, boolean, int, boolean)"), new Operation("void runAsync(java.lang.String, java.util.Map, boolean)"), new Operation("org.ofbiz.service.GenericResultWaiter runAsyncWait(java.lang.String, java.util.Map)"), new Operation("org.ofbiz.service.GenericResultWaiter runAsyncWait(java.lang.String, java.util.Map, boolean)"), new Operation("java.util.Map runSync(java.lang.String, java.util.Map)"), new Operation("java.util.Map runSync(java.lang.String, java.util.Map, int, boolean)"), new Operation("void runSyncIgnore(java.lang.String, java.util.Map)"), new Operation("void runSyncIgnore(java.lang.String, java.util.Map, int, boolean)"), new Operation("void schedule(java.lang.String, java.util.Map, long)"), new Operation("void schedule(java.lang.String, java.util.Map, long, int, int, int)"), new Operation("void schedule(java.lang.String, java.util.Map, long, int, int, int, long)"), new Operation("void schedule(java.lang.String, java.util.Map, long, int, int, long)") };
  private static final long interfaceHash = 5658062257718870582L;

  public void dispatch(Remote paramRemote, RemoteCall paramRemoteCall, int paramInt, long paramLong)
    throws Exception
  {
    if (paramInt < 0)
    {
      if (paramLong == 7388701430291161509L)
      {
        paramInt = 0;
      }
      if (paramLong == 4461126433741467972L)
      {
        paramInt = 1;
      }
      if (paramLong == -8254594307630171602L)
      {
        paramInt = 2;
      }
      if (paramLong == 7952886269633016064L)
      {
        paramInt = 3;
      }
      if (paramLong == 3627120838063131527L)
      {
        paramInt = 4;
      }
      if (paramLong == 7465872921023252277L)
      {
        paramInt = 5;
      }
      if (paramLong == 2852019610591249218L)
      {
        paramInt = 6;
      }
      if (paramLong == 3117439646154131779L)
      {
        paramInt = 7;
      }
      if (paramLong == -3631901869379275227L)
      {
        paramInt = 8;
      }
      if (paramLong == -5380780906253906391L)
      {
        paramInt = 9;
      }
      if (paramLong == 3055758260638559780L)
      {
        paramInt = 10;
      }
      if (paramLong == 61220135417632594L)
      {
        paramInt = 11;
      }
      if (paramLong == -3162534681576044283L)
      {
        paramInt = 12;
      }
      if (paramLong == -214200713778138959L)
      {
        paramInt = 13;
      }
      if (paramLong == 8014934600388704671L)
      {
        paramInt = 14;
      }
      throw new UnmarshalException("invalid method hash");
    }
    if (paramLong != 5658062257718870582L)
      throw new SkeletonMismatchException("interface hash mismatch");
    RemoteDispatcherImpl localRemoteDispatcherImpl = (RemoteDispatcherImpl)paramRemote;
    String str;
    Map localMap1;
    GenericRequester localGenericRequester;
    boolean bool3;
    Object localObject17;
    long l1;
    int l;
    int i1;
    int i2;
    switch (paramInt)
    {
    case 0:
      try
      {
        ObjectInput localObjectInput1 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput1.readObject();
        localMap1 = (Map)localObjectInput1.readObject();
      }
      catch (IOException localIOException7)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException7);
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException1);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.runAsync(str, localMap1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException1)
      {
        throw new MarshalException("error marshalling return", localIOException1);
      }
    case 1:
      try
      {
        ObjectInput localObjectInput4 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput4.readObject();
        localMap1 = (Map)localObjectInput4.readObject();
        localGenericRequester = (GenericRequester)localObjectInput4.readObject();
      }
      catch (IOException localIOException15)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException15);
      }
      catch (ClassNotFoundException localClassNotFoundException5)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException5);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.runAsync(str, localMap1, localGenericRequester);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException3)
      {
        throw new MarshalException("error marshalling return", localIOException3);
      }
    case 2:
      try
      {
        ObjectInput localObjectInput7 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput7.readObject();
        localMap1 = (Map)localObjectInput7.readObject();
        localGenericRequester = (GenericRequester)localObjectInput7.readObject();
        bool3 = localObjectInput7.readBoolean();
      }
      catch (IOException localIOException19)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException19);
      }
      catch (ClassNotFoundException localClassNotFoundException8)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException8);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.runAsync(str, localMap1, localGenericRequester, bool3);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException8)
      {
        throw new MarshalException("error marshalling return", localIOException8);
      }
    case 3:
      int k;
      boolean bool6;
      try
      {
        ObjectInput localObjectInput11 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput11.readObject();
        localMap1 = (Map)localObjectInput11.readObject();
        localGenericRequester = (GenericRequester)localObjectInput11.readObject();
        bool3 = localObjectInput11.readBoolean();
        k = localObjectInput11.readInt();
        bool6 = localObjectInput11.readBoolean();
      }
      catch (IOException localIOException25)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException25);
      }
      catch (ClassNotFoundException localClassNotFoundException12)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException12);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.runAsync(str, localMap1, localGenericRequester, bool3, k, bool6);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException20)
      {
        throw new MarshalException("error marshalling return", localIOException20);
      }
    case 4:
      boolean bool1;
      try
      {
        ObjectInput localObjectInput5 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput5.readObject();
        localMap1 = (Map)localObjectInput5.readObject();
        bool1 = localObjectInput5.readBoolean();
      }
      catch (IOException localIOException16)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException16);
      }
      catch (ClassNotFoundException localClassNotFoundException6)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException6);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.runAsync(str, localMap1, bool1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException4)
      {
        throw new MarshalException("error marshalling return", localIOException4);
      }
    case 5:
      try
      {
        ObjectInput localObjectInput2 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput2.readObject();
        localMap1 = (Map)localObjectInput2.readObject();
      }
      catch (IOException localIOException9)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException9);
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException2);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      GenericResultWaiter localGenericResultWaiter1 = localRemoteDispatcherImpl.runAsyncWait(str, localMap1);
      try
      {
        ObjectOutput localObjectOutput1 = paramRemoteCall.getResultStream(true);
        localObjectOutput1.writeObject(localGenericResultWaiter1);
      }
      catch (IOException localIOException5)
      {
        throw new MarshalException("error marshalling return", localIOException5);
      }
    case 6:
      boolean bool2;
      try
      {
        ObjectInput localObjectInput6 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput6.readObject();
        localMap1 = (Map)localObjectInput6.readObject();
        bool2 = localObjectInput6.readBoolean();
      }
      catch (IOException localIOException17)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException17);
      }
      catch (ClassNotFoundException localClassNotFoundException7)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException7);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      GenericResultWaiter localGenericResultWaiter2 = localRemoteDispatcherImpl.runAsyncWait(str, localMap1, bool2);
      try
      {
        ObjectOutput localObjectOutput3 = paramRemoteCall.getResultStream(true);
        localObjectOutput3.writeObject(localGenericResultWaiter2);
      }
      catch (IOException localIOException10)
      {
        throw new MarshalException("error marshalling return", localIOException10);
      }
    case 7:
      try
      {
        ObjectInput localObjectInput3 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput3.readObject();
        localMap1 = (Map)localObjectInput3.readObject();
      }
      catch (IOException localIOException11)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException11);
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException3);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      Map localMap2 = localRemoteDispatcherImpl.runSync(str, localMap1);
      try
      {
        ObjectOutput localObjectOutput2 = paramRemoteCall.getResultStream(true);
        localObjectOutput2.writeObject(localMap2);
      }
      catch (IOException localIOException6)
      {
        throw new MarshalException("error marshalling return", localIOException6);
      }
    case 8:
      int i;
      boolean bool4;
      try
      {
        ObjectInput localObjectInput8 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput8.readObject();
        localMap1 = (Map)localObjectInput8.readObject();
        i = localObjectInput8.readInt();
        bool4 = localObjectInput8.readBoolean();
      }
      catch (IOException localIOException21)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException21);
      }
      catch (ClassNotFoundException localClassNotFoundException9)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException9);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localObject17 = localRemoteDispatcherImpl.runSync(str, localMap1, i, bool4);
      try
      {
        ObjectOutput localObjectOutput4 = paramRemoteCall.getResultStream(true);
        localObjectOutput4.writeObject(localObject17);
      }
      catch (IOException localIOException18)
      {
        throw new MarshalException("error marshalling return", localIOException18);
      }
    case 9:
      try
      {
        localObject17 = paramRemoteCall.getInputStream();
        str = (String)((ObjectInput)localObject17).readObject();
        localMap1 = (Map)((ObjectInput)localObject17).readObject();
      }
      catch (IOException localIOException12)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException12);
      }
      catch (ClassNotFoundException localClassNotFoundException4)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException4);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.runSyncIgnore(str, localMap1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException2)
      {
        throw new MarshalException("error marshalling return", localIOException2);
      }
    case 10:
      int j;
      boolean bool5;
      try
      {
        ObjectInput localObjectInput9 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput9.readObject();
        localMap1 = (Map)localObjectInput9.readObject();
        j = localObjectInput9.readInt();
        bool5 = localObjectInput9.readBoolean();
      }
      catch (IOException localIOException22)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException22);
      }
      catch (ClassNotFoundException localClassNotFoundException10)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException10);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.runSyncIgnore(str, localMap1, j, bool5);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException13)
      {
        throw new MarshalException("error marshalling return", localIOException13);
      }
    case 11:
      try
      {
        ObjectInput localObjectInput10 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput10.readObject();
        localMap1 = (Map)localObjectInput10.readObject();
        l1 = localObjectInput10.readLong();
      }
      catch (IOException localIOException23)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException23);
      }
      catch (ClassNotFoundException localClassNotFoundException11)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException11);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.schedule(str, localMap1, l1);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException14)
      {
        throw new MarshalException("error marshalling return", localIOException14);
      }
    case 12:
      try
      {
        ObjectInput localObjectInput12 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput12.readObject();
        localMap1 = (Map)localObjectInput12.readObject();
        l1 = localObjectInput12.readLong();
        l = localObjectInput12.readInt();
        i1 = localObjectInput12.readInt();
        i2 = localObjectInput12.readInt();
      }
      catch (IOException localIOException27)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException27);
      }
      catch (ClassNotFoundException localClassNotFoundException13)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException13);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.schedule(str, localMap1, l1, l, i1, i2);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException24)
      {
        throw new MarshalException("error marshalling return", localIOException24);
      }
    case 13:
      long l3;
      try
      {
        ObjectInput localObjectInput14 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput14.readObject();
        localMap1 = (Map)localObjectInput14.readObject();
        l1 = localObjectInput14.readLong();
        l = localObjectInput14.readInt();
        i1 = localObjectInput14.readInt();
        i2 = localObjectInput14.readInt();
        l3 = localObjectInput14.readLong();
      }
      catch (IOException localIOException30)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException30);
      }
      catch (ClassNotFoundException localClassNotFoundException15)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException15);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.schedule(str, localMap1, l1, l, i1, i2, l3);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException28)
      {
        throw new MarshalException("error marshalling return", localIOException28);
      }
    case 14:
      long l2;
      try
      {
        ObjectInput localObjectInput13 = paramRemoteCall.getInputStream();
        str = (String)localObjectInput13.readObject();
        localMap1 = (Map)localObjectInput13.readObject();
        l1 = localObjectInput13.readLong();
        l = localObjectInput13.readInt();
        i1 = localObjectInput13.readInt();
        l2 = localObjectInput13.readLong();
      }
      catch (IOException localIOException29)
      {
        throw new UnmarshalException("error unmarshalling arguments", localIOException29);
      }
      catch (ClassNotFoundException localClassNotFoundException14)
      {
        throw new UnmarshalException("error unmarshalling arguments", localClassNotFoundException14);
      }
      finally
      {
        paramRemoteCall.releaseInputStream();
      }
      localRemoteDispatcherImpl.schedule(str, localMap1, l1, l, i1, l2);
      try
      {
        paramRemoteCall.getResultStream(true);
      }
      catch (IOException localIOException26)
      {
        throw new MarshalException("error marshalling return", localIOException26);
      }
    }
    throw new UnmarshalException("invalid method number");
  }

  public Operation[] getOperations()
  {
    return (Operation[])operations.clone();
  }
}

/* Location:           D:\core\dragonflow\siteview\ofbiz\framework\service\build\classes\
 * Qualified Name:     org.ofbiz.service.rmi.RemoteDispatcherImpl_Skel
 * JD-Core Version:    0.5.4
 */