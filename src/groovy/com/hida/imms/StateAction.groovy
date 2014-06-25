package com.hida.imms

import com.hida.imms.workorder.WorkOrderState

/**
 * Created by arief.hidayat on 24/06/2014.
 */
interface StateAction<T> {
//    List<ActionView> actionList(String workflowId, String userId) // list of action that can be performed by user on this state
    StateAction<T> next(T item, ActionInfo actionInfo)
    StateAction<T> save(T item, ActionInfo actionInfo)
    StateAction<T> back(T item, ActionInfo actionInfo)
}
