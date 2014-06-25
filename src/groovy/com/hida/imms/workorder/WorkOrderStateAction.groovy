package com.hida.imms.workorder

import com.hida.imms.ActionInfo

/**
 * Created by arief.hidayat on 24/06/2014.
 */
interface WorkOrderStateAction {
//    List<ActionView> actionList(String workflowId, String userId) // list of action that can be performed by user on this state
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo)
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo)
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo)
}
