/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package request.resource.notfound;

import org.juzu.Controller;
import org.juzu.Resource;
import org.juzu.Response;
import org.juzu.View;

import javax.naming.AuthenticationException;
import java.io.IOException;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class A extends Controller
{

   public A()
   {
   }

   @Resource
   public Response.Content.Resource resource() throws AuthenticationException
   {
      return Response.notFound("not_found");
   }

   @View
   public Response.Content index() throws IOException
   {
      return Response.content(A_.resourceURL().toString());
   }
}
