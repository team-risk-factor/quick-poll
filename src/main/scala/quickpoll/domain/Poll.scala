package quickpoll.domain

import javax.persistence.{CascadeType, Column, Entity, GeneratedValue, Id, JoinColumn, OneToMany, OrderBy}

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Entity
case class Poll(
    @(Id@field) @(GeneratedValue@field) @(Column@field)(name="POLL_ID") @BeanProperty
    id: java.lang.Long,
    
    @(Column@field)(name="QUESTION") @BeanProperty
    question: String,
    
    @(OneToMany@field)(cascade=Array(CascadeType.ALL)) @(JoinColumn@field)(name="POLL_ID") @(OrderBy@field) @BeanProperty
    options: java.util.Set[Option] = null
) {
    def this() = {
        this(null, null, null)
    }
}
