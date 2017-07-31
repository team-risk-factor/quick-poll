package quickpoll.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
@SerialVersionUID(1)
class ResourceNotFoundException(message: String, cause: Throwable) extends RuntimeException(message, cause) {
  def this() = {
    this(null, null)
  }

  def this(message: String) = {
    this(message, null)
  }

}
