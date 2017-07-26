package quickpoll.domain

import javax.persistence.{Column, Entity, GeneratedValue, Id, JoinColumn, ManyToOne}

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Entity
case class Vote(
    @(Id@field) @(GeneratedValue@field)@(Column@field)(name="VOTE_ID") @BeanProperty
    id: java.lang.Long,
    
    @(ManyToOne@field) @(JoinColumn@field)(name="OPTION_ID") @BeanProperty
    option: Option
) {
    def this() = {
        this(null, null)
    }
}