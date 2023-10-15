<%-- 
    Document   : newCode
    Created on : 11 oct. 2023, 09:14:52
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="https://cdn.tailwindcss.com"></script>
          <script>
            tailwind.config = {
                theme: {
                    screens: {
                        sm: '480px',
                        md: '768px',
                        lg: '976px',
                        xl: '1440px',
                    },
                    extend: {
                        colors: {
                            clifford: '#da373d',
                        }
                    }
                }
            }
        </script>
        <title>JSP Page</title>
    </head>
    <form method="POST" action="NewCode" class="flex justify-center items-center h-screen bg-sky-200">
        <div class="w-96 p-6 shadow-lg bg-white rounded-md">
            <h1 class="text-3xl block text-center font-semibold"><i class="fa-solid fa-user"></i>Code </h1>
            <hr class="mt-3">
            <div class="mt-3">
                <label class="block text-base mb-2">Code </label>
                <input type="text" name="code" class="border w-full text-base px-2 py-1 focus:outline-none focus:ring-0 focus:border-gray-600" placeholder="Entrer le code ..." />
            </div>
            <%
                String errorMsg = (String) request.getParameter("msg");
                if (errorMsg != null) {
            %>
            <div class="mt-3 text-red-500"><%= errorMsg%></div>
            <%
                }
            %>


            <div class="mt-5">
               <button type="submit" name="submit" class="border-2 border-indigo-700 bg-indigo-700 text-white py-1 w-full rounded-md hover:bg-transparent hover:text-indigo-700 font-semibold"><i class="fa-solid fa-right-to-bracket"></i>&nbsp;&nbsp;valider</button>

            </div>
        </div>
    </form>
</html>
