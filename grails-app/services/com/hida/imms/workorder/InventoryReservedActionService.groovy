package com.hida.imms.workorder

import com.hida.imms.UnsupportedStatusTransitionException
import grails.transaction.Transactional

/**
 *
 */
@Transactional
class InventoryReservedActionService implements WorkOrderStateAction {
    @Override
    WorkOrderState next(String workflowId, WorkOrder item) {
        item.save(failOnError: true)
        return WorkOrderState.INVENTORY_RELEASED
    }

    @Override
    WorkOrderState save(String workflowId, WorkOrder item) {
//        throw new UnsupportedStatusTransitionException() // if disallow partial release
        //if allow partial release
        // check if all parts have been released
        boolean allPartsReleased = true
        return allPartsReleased ? WorkOrderState.INVENTORY_RELEASED : WorkOrderState.INVENTORY_RESERVED
    }

    @Override
    WorkOrderState back(String workflowId, WorkOrder item) {
        throw new UnsupportedStatusTransitionException()

//        boolean cancelWorkOrder = false
//        if(cancelWorkOrder) {
//            // delete workflow record
//            // delete work order
//            // create work cancellation record and the reason.
//            item.delete()
//            return WorkOrderState.WORK_CANCELLED
//        } else {
//            // only cancel reservation
//            // rollback reservation
//            return WorkOrderState.MANAGER_APPROVED // there must be a UI to allow user to trigger re-reservation.
//        }
    }
}
