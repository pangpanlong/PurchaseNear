// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `ResetService.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package cn.purchasenear.service.reset.Reset;

public final class _ResetServiceDelD extends Ice._ObjectDelD implements _ResetServiceDel
{
    public ResetInfo flashsales(final long orderId, final long flashSalesId, java.util.Map<String, String> __ctx, Ice.Instrumentation.InvocationObserver __observer)
        throws IceInternal.LocalExceptionWrapper
    {
        final Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "flashsales", Ice.OperationMode.Normal, __ctx);
        final ResetInfoHolder __result = new ResetInfoHolder();
        IceInternal.Direct __direct = null;
        try
        {
            __direct = new IceInternal.Direct(__current)
            {
                public Ice.DispatchStatus run(Ice.Object __obj)
                {
                    ResetService __servant = null;
                    if(__obj == null || __obj instanceof ResetService)
                    {
                        __servant = (ResetService)__obj;
                    }
                    else
                    {
                        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
                    }
                    __result.value = __servant.flashsales(orderId, flashSalesId, __current);
                    return Ice.DispatchStatus.DispatchOK;
                }
            };
            try
            {
                Ice.DispatchStatus __status = __direct.getServant().__collocDispatch(__direct);
                if(__status == Ice.DispatchStatus.DispatchUserException)
                {
                    __direct.throwUserException();
                }
                assert __status == Ice.DispatchStatus.DispatchOK;
                return __result.value;
            }
            finally
            {
                __direct.destroy();
            }
        }
        catch(Ice.SystemException __ex)
        {
            throw __ex;
        }
        catch(java.lang.Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwWrapper(__ex);
        }
        return __result.value;
    }
}
