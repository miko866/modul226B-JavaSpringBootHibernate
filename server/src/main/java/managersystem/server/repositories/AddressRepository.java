package managersystem.server.repositories;

import managersystem.server.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a WHERE a.client_id = :client_id")
    List<Address> getClientAddress(@Param("client_id") Integer client_id);
}
