package academy.devdojo.youtube.auth.security.user;

import academy.devdojo.youtube.core.model.ApplicationUser;
import academy.devdojo.youtube.core.repository.ApplicationRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ApplicationRepository applicationRepository;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        log.info("Searching in the DB the user by username '{}'",username);
        ApplicationUser applicationUser = applicationRepository.findByUsername(username);
        log.info("ApplicationUser found '{}'", applicationUser);

        if (applicationUser == null)
            throw new UsernameNotFoundException(String.format("Application user '%s' not found", username));
        return new CustomUserDetails(applicationUser);
    }

    private static final class CustomUserDetails extends ApplicationUser implements UserDetails {

        public CustomUserDetails(@NotNull ApplicationUser applicationUser){
            super (applicationUser);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return commaSeparatedStringToAuthorityList("ROLE_" + this.getRole());
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }
    }
}
