package quickpoll.domain

import javax.persistence.{Column, Entity, GeneratedValue, Id}
import scala.annotation.meta.field

@Entity
case class Option(
    @(Id@field) @(GeneratedValue@field) @(Column@field)(name="OPTION_ID") 
    id: Long = null.asInstanceOf[Long],
    
    @(Column@field)(name="OPTION_VALUE") 
    value: String = null
)
