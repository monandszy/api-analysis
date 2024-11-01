package code.configuration;

public interface TestSupport {

/*   default void stubForGetTask(final WireMockServer wireMockServer) {
      UrlPattern urlPattern = WireMock.urlPathEqualTo("/" + Endpoints.getTasksPath);
      wireMockServer.stubFor(WireMock.get(urlPattern)
          .willReturn(WireMock.aResponse()
              .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
              .withBodyFile("getSquareTask.json")
              .withTransformers("response-template")));
   }

   default void stubForGetWorksheets(final WireMockServer wireMockServer) {
      UrlPattern urlPattern = WireMock.urlPathEqualTo("/" + Endpoints.getWorksheetsPath);

      wireMockServer.stubFor(WireMock.get(urlPattern)
          .willReturn(WireMock.aResponse()
              .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
              .withBodyFile("getWorksheets.json")
              .withTransformers("response-template")));
   }
   default void stubForGetChapters(final WireMockServer wireMockServer) {
      UrlPattern urlPattern = WireMock.urlPathEqualTo("/" + Endpoints.getChaptersPath);
      wireMockServer.stubFor(WireMock.get(urlPattern)
          .willReturn(WireMock.aResponse()
              .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
              .withBodyFile("getChapters.json")
              .withTransformers("response-template")));
   }*/
}