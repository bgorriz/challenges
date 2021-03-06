package repositories

import model.Flight
import play.api.Logger

class RecordingFlightsRepository extends FlightsRepository {

  var lastInserted = None : Option[Flight]
  var lastDeleted = None: Option[String]
  var lastStatusUpdated = None: Option[(String, String)]
  var lastFlightsTo = None: Option[(String, Long, Long)]
  var lastFlightsFrom = None: Option[(String, Long, Long)]
  
  def reset() = {
    lastInserted = None
    lastDeleted = None
    lastStatusUpdated = None
    lastFlightsTo = None
    lastFlightsFrom = None
  }
  
  def insert(f: Flight) = {
    lastInserted = Some(f)
  }

  def flightsTo(id: String, from: Long, to: Long): Iterable[Flight] = {
    lastFlightsTo = Some((id, from, to))
    List()
  }

  def flightsFrom(id: String, from: Long, to: Long): Iterable[Flight] = {
    lastFlightsFrom = Some((id, from, to))
    List()
  }

  def updateStatus(id: String, status: String) = {
    lastStatusUpdated = Some((id, status))
  }

  def delete(id: String) = {
    lastDeleted = Some(id)
  }
}