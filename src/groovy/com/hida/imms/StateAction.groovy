package com.hida.imms

import com.hida.imms.workorder.WorkOrderState

/**
 * Created by arief.hidayat on 24/06/2014.
 */
interface StateAction<T> {
//    List<ActionView> actionList(String workflowId, String userId) // list of action that can be performed by user on this state
    WorkOrderState next(T item, ActionInfo actionInfo)
    WorkOrderState save(T item, ActionInfo actionInfo)
    WorkOrderState back(T item, ActionInfo actionInfo)
}
