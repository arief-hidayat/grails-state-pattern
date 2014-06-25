package com.hida.imms.workorder
/**
 * Created by arief.hidayat on 24/06/2014.
 */
interface WorkOrderStateAction {
//    List<ActionView> actionList(String workflowId, String userId) // list of action that can be performed by user on this state
    WorkOrderState next(String workflowId, WorkOrder item)
    WorkOrderState save(String workflowId, WorkOrder item)
    WorkOrderState back(String workflowId, WorkOrder item)
}
