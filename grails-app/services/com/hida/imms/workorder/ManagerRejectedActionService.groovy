package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import com.hida.imms.StateAction
import grails.transaction.Transactional

/**
 * engineer to rework a rejected-work-order or cancel it.
 */
@Transactional
class ManagerRejectedActionService implements StateAction<WorkOrder> {

    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        return WorkOrderState.ENGINEER_DRAFT
    }

    @Override
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        WorkOrderState.MANAGER_REJECTED
    }

    @Override
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo) {
        return WorkOrderState.ENGINEER_DRAFT.back(item, actionInfo)
    }
}

