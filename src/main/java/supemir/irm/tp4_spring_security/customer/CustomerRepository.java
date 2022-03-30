package supemir.irm.tp4_spring_security.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @GetMapping(path = "/customers/email/")
    Page<Customer> findCustomerByEmailContains(String email, Pageable pageable);
}
