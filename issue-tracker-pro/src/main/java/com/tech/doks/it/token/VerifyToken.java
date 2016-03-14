package com.tech.doks.it.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.xml.bind.DatatypeConverter;

public class VerifyToken {

	public boolean parseJWT(Object jwt) {

		boolean isValidToken = false;
		
		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("issue-tracker-pro"))
					.parseClaimsJws(jwt.toString()).getBody();
			if(!claims.equals(null)) {
				isValidToken = true;
			}
			System.out.println("ID: " + claims.getId());
			System.out.println("Subject: " + claims.getSubject());
			System.out.println("Issuer: " + claims.getIssuer());
			System.out.println("Expiration: " + claims.getExpiration());
		} catch (io.jsonwebtoken.MalformedJwtException e) {
			System.out.println("Token is not in proper format. It must contain exactly 2 period characters.");
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("Token is NULL");
		} catch (io.jsonwebtoken.SignatureException e) {
			System.out.println("Invalid Token !!");
		} catch (io.jsonwebtoken.ExpiredJwtException e) {
			System.out.println("Token Expired");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isValidToken;
	}
}