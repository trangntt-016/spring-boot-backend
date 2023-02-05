/*
 * Copyright (c) 2023 The Trebol eCommerce Project
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished
 * to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.trebol.jpa.services.datatransport;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.trebol.api.models.UserRolePojo;
import org.trebol.common.exceptions.BadInputException;
import org.trebol.jpa.entities.UserRole;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserRolesDataTransportServiceImplTest {
  @InjectMocks UserRolesDataTransportServiceImpl sut;
  UserRole userRole;
  UserRolePojo userRolePojo;

  @BeforeEach
  void beforeEach() {
    userRole = new UserRole();
    userRole.setName("ANY");
    userRole.setId(1L);
    userRolePojo = UserRolePojo.builder()
      .id(1L)
      .name("ANY")
      .build();
  }

  @AfterEach
  void afterEach() {
    userRole = null;
    userRolePojo = null;
  }

  @Test
  void testApplyChangesToExistingEntity() throws BadInputException {
    UserRole actual = sut.applyChangesToExistingEntity(userRolePojo, userRole);
    assertEquals(1L, actual.getId());
  }
}
