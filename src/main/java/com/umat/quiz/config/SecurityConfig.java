@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .cors(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())
        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
            // 1. Always permit the error path so you see real messages
            .requestMatchers("/error").permitAll()
            
            // 2. Permit all Auth endpoints WITH wildcards (CRITICAL)
            // This covers /api/auth/student/login, /api/auth/lecturer/login, etc.
            .requestMatchers("/api/auth/**", "/auth/**").permitAll()
            .requestMatchers("/api/public/**", "/public/**").permitAll()
            .requestMatchers("/api/recording/stream/**").permitAll()
            
            // 3. Authenticated paths
            .requestMatchers("/api/ai/**", "/api/results/**").authenticated()
            
            // 4. Lock everything else
            .anyRequest().authenticated()
        );
    return http.build();
}