package quickpoll.domain

import javax.persistence.{Column, Entity, GeneratedValue, Id, OneToMany, JoinColumn, CascadeType, OrderBy}
import scala.annotation.meta.field

@Entity
case class Poll(
    @(Id@field) @(GeneratedValue@field) @(Column@field)(name="POLL_ID") 
    id: Long = null.asInstanceOf[Long],
    
    @(Column@field)(name="QUESTION") 
    question: String = null,
    
    @(OneToMany@field)(cascade=Array(CascadeType.ALL)) @(JoinColumn@field)(name="POLL_ID") @(OrderBy@field) 
    options: java.util.Set[Option] = null
)