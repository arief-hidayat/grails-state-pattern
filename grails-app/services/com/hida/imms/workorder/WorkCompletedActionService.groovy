package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import com.hida.imms.StateAction
import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

/**
 * time to return excessive parts (if any)
 */
@Transactional
class WorkCompletedActionService  implements StateAction<WorkOrder> {

    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        return WorkOrderState.WORK_COMPLETED
    }

    @Override
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        boolean isInterruption = true
        isInterruption? WorkOrderState.WORK_INTERRUPTED : WorkOrderState.WORK_IN_PROGRESS
    }

    @Override
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo) {
        throw new UnsupportedStatusTransitionException()
    }
}