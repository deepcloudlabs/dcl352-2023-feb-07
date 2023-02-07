package com.example.hr.domain;

import java.util.Base64;
import java.util.Objects;

import com.example.ddd.ValueObject;

@ValueObject
public final class Photo {
	private final byte[] values;

	private Photo(byte[] values) {
		this.values = values;
	}

	public static Photo of(String values) {
		return of(Base64.getDecoder().decode(values));
	}

	public static Photo of(byte[] values) {
		Objects.requireNonNull(values);
		return new Photo(values);
	}

	public byte[] getValues() {
		return values;
	}

	public String getBase64Values() {
		return Base64.getEncoder().encodeToString(values);
	}

}
