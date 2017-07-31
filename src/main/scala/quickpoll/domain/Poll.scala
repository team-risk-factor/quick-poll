package quickpoll.domain

import javax.persistence.{CascadeType, Column, Entity, GeneratedValue, Id, JoinColumn, OneToMany, OrderBy}
import javax.validation.constraints.Size

import org.hibernate.validator.constraints.NotEmpty

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Entity
case class Poll(
    @(Id@field) @(GeneratedValue@field) @(Column@field)(name="POLL_ID") @BeanProperty
    id: java.lang.Long,
    
    @(Column@field)(name="QUESTION") @(NotEmpty@field) @BeanProperty
    question: String,
    
    @(OneToMany@field)(cascade=Array(CascadeType.ALL)) @(JoinColumn@field)(name="POLL_ID") @(OrderBy@field) @(Size@field)(min = 2, max = 4) @BeanProperty
    options: java.util.Set[Option] = null
) {
    def this() = {
        this(null, null, null)
    }
}
