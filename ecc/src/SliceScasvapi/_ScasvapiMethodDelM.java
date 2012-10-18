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

public final class _ScasvapiMethodDelM extends Ice._ObjectDelM implements _ScasvapiMethodDel
{
    public boolean
    SliceGetForestData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestListHolder flist, Ice.StringHolder estr, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __handler.getOutgoing("SliceGetForestData", Ice.OperationMode.Idempotent, __ctx);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                SNodeDataHelper.write(__os, inwhat);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                if(!__ok)
                {
                    try
                    {
                        __og.throwUserException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                IceInternal.BasicStream __is = __og.is();
                __is.startReadEncaps();
                flist.value = SForestListHelper.read(__is);
                estr.value = __is.readString();
                boolean __ret;
                __ret = __is.readBool();
                __is.endReadEncaps();
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __handler.reclaimOutgoing(__og);
        }
    }

    public boolean
    SliceGetUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestMapHolder fmap, Ice.StringHolder estr, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __handler.getOutgoing("SliceGetUnivData", Ice.OperationMode.Idempotent, __ctx);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                SNodeDataHelper.write(__os, inwhat);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                if(!__ok)
                {
                    try
                    {
                        __og.throwUserException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                IceInternal.BasicStream __is = __og.is();
                __is.startReadEncaps();
                fmap.value = SForestMapHelper.read(__is);
                estr.value = __is.readString();
                boolean __ret;
                __ret = __is.readBool();
                __is.endReadEncaps();
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __handler.reclaimOutgoing(__og);
        }
    }

    public boolean
    SliceSubmitUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> ifmap, SForestMapHolder ofmap, Ice.StringHolder estr, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __handler.getOutgoing("SliceSubmitUnivData", Ice.OperationMode.Idempotent, __ctx);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                SNodeDataHelper.write(__os, inwhat);
                SForestMapHelper.write(__os, ifmap);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                if(!__ok)
                {
                    try
                    {
                        __og.throwUserException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                IceInternal.BasicStream __is = __og.is();
                __is.startReadEncaps();
                ofmap.value = SForestMapHelper.read(__is);
                estr.value = __is.readString();
                boolean __ret;
                __ret = __is.readBool();
                __is.endReadEncaps();
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __handler.reclaimOutgoing(__og);
        }
    }

    public void
    shutdown(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __handler.getOutgoing("shutdown", Ice.OperationMode.Idempotent, __ctx);
        try
        {
            boolean __ok = __og.invoke();
            if(!__og.is().isEmpty())
            {
                try
                {
                    if(!__ok)
                    {
                        try
                        {
                            __og.throwUserException();
                        }
                        catch(Ice.UserException __ex)
                        {
                            throw new Ice.UnknownUserException(__ex.ice_name());
                        }
                    }
                    __og.is().skipEmptyEncaps();
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
        }
        finally
        {
            __handler.reclaimOutgoing(__og);
        }
    }
}
