<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link href="static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="static/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="static/css/sb-admin.css" rel="stylesheet">
    <!-- Bootstrap core JavaScript-->
    <script src="static/vendor/jquery/jquery.min.js"></script>
    <script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="static/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="static/vendor/chart.js/Chart.min.js"></script>
    <script src="static/vendor/datatables/jquery.dataTables.js"></script>
    <script src="static/vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Captcha Google -->
    <script src="https://www.google.com/recaptcha/api.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="static/js/sb-admin.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
    </script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#locales").change(function () {
                var selectedOption = $('#locales').val();
                if (selectedOption !== ''){
                    window.location.replace('?lang=' + selectedOption);
                }
            });
        });
    </script>
</head>