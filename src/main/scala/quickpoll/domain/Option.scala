package quickpoll.domain

import javax.persistence.{Column, Entity, GeneratedValue, Id}

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Entity
case class Option(
    // We must annotate the annotation with @field to flag that @Id applies to the variable, not the next annotation
    @(Id@field) @(GeneratedValue@field) @(Column@field)(name="OPTION_ID") @BeanProperty
    id: java.lang.Long,
    
    @(Column@field)(name="OPTION_VALUE") @BeanProperty
    value: String
) {
  def this() = {
    this(null, null)
  }
}
