package quickpoll.domain

import javax.persistence.{Column, Entity, GeneratedValue, Id, ManyToOne, JoinColumn}
import scala.annotation.meta.field

@Entity
case class Vote(
    @(Id@field) @(GeneratedValue@field)@Column(name="VOTE_ID") 
    id: Long = null.asInstanceOf[Long],
    
    @(ManyToOne@field) @(JoinColumn@field)(name="OPTION_ID") 
    option: Option = null
)