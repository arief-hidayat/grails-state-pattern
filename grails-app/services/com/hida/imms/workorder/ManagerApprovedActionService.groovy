package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

/**
 * after manager approved, system tries to reserve
 */
@Transactional
class ManagerApprovedActionService implements WorkOrderStateAction {

    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        boolean reservationOk = true
        // if reservation failed, return back to engineer to wait.
        reservationOk ? WorkOrderState.INVENTORY_RESERVED : WorkOrderState.MANAGER_APPROVED
    }

    @Override
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo) {
        throw new UnsupportedStatusTransitionException()
    }

    @Override
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo) {
        // rollback reservation
        return WorkOrderState.ENGINEER_DRAFT.back(item, actionInfo)
    }
}

