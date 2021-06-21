package com.app.util;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;

public final class ValidatorUtil {

  public static void checkNullableIdentity(Long id) throws NullableObjectIdentityException {
    if (id == null) {
      throw new NullableObjectIdentityException();
    }
  }

  public static void checkNullableObject(Object obj) throws ObjectNotExistException {
    if (obj == null) {
      throw new ObjectNotExistException();
    }
  }
}
