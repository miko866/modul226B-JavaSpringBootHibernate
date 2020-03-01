package managersystem.server.repositories;

import managersystem.server.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("SELECT a FROM Contact a WHERE a.client_id = :client_id")
    List<Contact> getContactAddress(@Param("client_id") Integer client_id);
}
