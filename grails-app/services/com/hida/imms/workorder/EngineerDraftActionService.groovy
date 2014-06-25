package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import com.hida.imms.StateAction
import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

/**
 * manager to approve or reject.
 *
 */
@Transactional
class EngineerDraftActionService implements StateAction<WorkOrder> {
    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        boolean approved = true
        approved ? WorkOrderState.MANAGER_APPROVED : WorkOrderState.MANAGER_REJECTED
    }

    @Override
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo) {
        throw new UnsupportedStatusTransitionException()
    }

    @Override
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo) {
        //rollback what's done in WorkOrderState.PLANNER_DRAFT.next
        return WorkOrderState.PLANNER_DRAFT.back(item, actionInfo)
    }
}

