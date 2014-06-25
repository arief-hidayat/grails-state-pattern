package com.hida.imms.workorder

import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

/**
 * after manager approved, system tries to reserve
 */
@Transactional
class ManagerApprovedActionService implements WorkOrderStateAction {

    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        boolean reservationOk = true
        // if reservation failed, return back to engineer to wait.
        reservationOk ? WorkOrderState.INVENTORY_RESERVED : WorkOrderState.MANAGER_APPROVED
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
        throw new UnsupportedStatusTransitionException()
    }

    @Override
    WorkOrderState back(String workflowId, WorkOrder item) {
        // rollback reservation
        return WorkOrderState.ENGINEER_DRAFT.back(workflowId, item)
    }
}

