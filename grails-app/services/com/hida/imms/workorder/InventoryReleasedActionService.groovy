package com.hida.imms.workorder

import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

/**
 * inventory has been released, engineer declare the actual start date.
 */
@Transactional
class InventoryReleasedActionService  implements WorkOrderStateAction {
    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        return WorkOrderState.WORK_IN_PROGRESS
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
        throw new UnsupportedStatusTransitionException()
    }

    @Override
    WorkOrderState back(String workflowId, WorkOrder item) {
        return WorkOrderState.INVENTORY_RESERVED.back(workflowId, item)
    }
}
