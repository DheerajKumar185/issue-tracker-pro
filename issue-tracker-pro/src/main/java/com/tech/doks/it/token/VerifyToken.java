package com.tech.doks.it.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.xml.bind.DatatypeConverter;

public class VerifyToken {

	public boolean parseJWT(String jwt) {

		boolean isValidToken = false;
		
		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("issue-tracker-pro"))
					.parseClaimsJws(jwt).getBody();
			if(!claims.equals(null)) {
				isValidToken = true;
			}
			System.out.println("ID: " + claims.getId());
			System.out.println("Subject: " + claims.getSubject());
			System.out.println("Issuer: " + claims.getIssuer());
			System.out.println("Expiration: " + claims.getExpiration());
		} catch (io.jsonwebtoken.ExpiredJwtException e) {
			System.out.println("Token Expired");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isValidToken;
	}
}