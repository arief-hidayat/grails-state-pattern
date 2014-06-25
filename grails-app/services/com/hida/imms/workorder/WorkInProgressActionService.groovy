package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import grails.transaction.Transactional

/**
 * engineer in
 */
@Transactional
class WorkInProgressActionService implements WorkOrderStateAction {

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
        // return parts back to warehouse
        // release allocated resource
        return WorkOrderState.MANAGER_APPROVED.back(item, actionInfo)
    }
}