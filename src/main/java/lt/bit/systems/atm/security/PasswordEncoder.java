package lt.bit.systems.atm.security;

public interface PasswordEncoder {

	String encode(CharSequence rawPassword);
	boolean matches(CharSequence rawPassword, String encodedPassword);
}
