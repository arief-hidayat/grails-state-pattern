package com.hida.imms.workorder

import com.hida.imms.ActionInfo
import com.hida.imms.StateAction
import grails.transaction.Transactional

/**
 *
 */
@Transactional
class InventoryReservedActionService implements StateAction<WorkOrder> {
    @Override
    WorkOrderState next(WorkOrder item, ActionInfo actionInfo) {
        item.save(failOnError: true)
        return WorkOrderState.INVENTORY_RELEASED
    }

    @Override
    WorkOrderState save(WorkOrder item, ActionInfo actionInfo) {
//        throw new UnsupportedStatusTransitionException() // if disallow partial release
        //if allow partial release
        // check if all parts have been released
        boolean allPartsReleased = true
        return allPartsReleased ? WorkOrderState.INVENTORY_RELEASED : WorkOrderState.INVENTORY_RESERVED
    }

    @Override
    WorkOrderState back(WorkOrder item, ActionInfo actionInfo) {
//            // rollback reservation
        return WorkOrderState.MANAGER_APPROVED.back(item, actionInfo)
    }
}
