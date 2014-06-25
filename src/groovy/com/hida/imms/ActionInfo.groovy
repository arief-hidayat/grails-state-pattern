package com.hida.imms

import org.joda.time.LocalDateTime

/**
 * Created by arief.hidayat on 25/06/2014.
 */
class ActionInfo {
    String workflowId
    String userId
    String reason
    LocalDateTime time

    def otherInfo = [:]
}
