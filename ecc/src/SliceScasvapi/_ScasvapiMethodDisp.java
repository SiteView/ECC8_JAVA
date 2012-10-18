// **********************************************************************
//
// Copyright (c) 2003-2009 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.3.1

package SliceScasvapi;

public abstract class _ScasvapiMethodDisp extends Ice.ObjectImpl implements ScasvapiMethod
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::SliceScasvapi::ScasvapiMethod"
    };

    public boolean
    ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String
    ice_id()
    {
        return __ids[1];
    }

    public String
    ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    public final boolean
    SliceGetForestData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestListHolder flist, Ice.StringHolder estr)
    {
        return SliceGetForestData(inwhat, flist, estr, null);
    }

    public final boolean
    SliceGetUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestMapHolder fmap, Ice.StringHolder estr)
    {
        return SliceGetUnivData(inwhat, fmap, estr, null);
    }

    public final boolean
    SliceSubmitUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> ifmap, SForestMapHolder ofmap, Ice.StringHolder estr)
    {
        return SliceSubmitUnivData(inwhat, ifmap, ofmap, estr, null);
    }

    public final void
    shutdown()
    {
        shutdown(null);
    }

    public static Ice.DispatchStatus
    ___SliceGetUnivData(ScasvapiMethod __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        java.util.Map<java.lang.String, java.lang.String> inwhat;
        inwhat = SNodeDataHelper.read(__is);
        __is.endReadEncaps();
        SForestMapHolder fmap = new SForestMapHolder();
        Ice.StringHolder estr = new Ice.StringHolder();
        IceInternal.BasicStream __os = __inS.os();
        boolean __ret = __obj.SliceGetUnivData(inwhat, fmap, estr, __current);
        SForestMapHelper.write(__os, fmap.value);
        __os.writeString(estr.value);
        __os.writeBool(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___SliceSubmitUnivData(ScasvapiMethod __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        java.util.Map<java.lang.String, java.lang.String> inwhat;
        inwhat = SNodeDataHelper.read(__is);
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> ifmap;
        ifmap = SForestMapHelper.read(__is);
        __is.endReadEncaps();
        SForestMapHolder ofmap = new SForestMapHolder();
        Ice.StringHolder estr = new Ice.StringHolder();
        IceInternal.BasicStream __os = __inS.os();
        boolean __ret = __obj.SliceSubmitUnivData(inwhat, ifmap, ofmap, estr, __current);
        SForestMapHelper.write(__os, ofmap.value);
        __os.writeString(estr.value);
        __os.writeBool(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___SliceGetForestData(ScasvapiMethod __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        java.util.Map<java.lang.String, java.lang.String> inwhat;
        inwhat = SNodeDataHelper.read(__is);
        __is.endReadEncaps();
        SForestListHolder flist = new SForestListHolder();
        Ice.StringHolder estr = new Ice.StringHolder();
        IceInternal.BasicStream __os = __inS.os();
        boolean __ret = __obj.SliceGetForestData(inwhat, flist, estr, __current);
        SForestListHelper.write(__os, flist.value);
        __os.writeString(estr.value);
        __os.writeBool(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___shutdown(ScasvapiMethod __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        __inS.is().skipEmptyEncaps();
        __obj.shutdown(__current);
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "SliceGetForestData",
        "SliceGetUnivData",
        "SliceSubmitUnivData",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "shutdown"
    };

    public Ice.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___SliceGetForestData(this, in, __current);
            }
            case 1:
            {
                return ___SliceGetUnivData(this, in, __current);
            }
            case 2:
            {
                return ___SliceSubmitUnivData(this, in, __current);
            }
            case 3:
            {
                return ___ice_id(this, in, __current);
            }
            case 4:
            {
                return ___ice_ids(this, in, __current);
            }
            case 5:
            {
                return ___ice_isA(this, in, __current);
            }
            case 6:
            {
                return ___ice_ping(this, in, __current);
            }
            case 7:
            {
                return ___shutdown(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.endWriteSlice();
        super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readTypeId();
        }
        __is.startReadSlice();
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type SliceScasvapi::ScasvapiMethod was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type SliceScasvapi::ScasvapiMethod was not generated with stream support";
        throw ex;
    }
}
