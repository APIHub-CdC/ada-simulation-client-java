# ada-simulation-client-java

This API simulates the aggregation of bank data from a source.<br/><br><img src='https://developer.circulodecredito.com.mx/sites/default/files/2020-10/circulo_de_credito-apihub.png' height='40' width='220'/></p><br/>

## Requirements

1. Java >= 1.7
2. Maven >= 3.3
## Installation

To install the dependencies, the following command must be executed:
```shell
mvn install -Dmaven.test.skip=true
```
## Getting started

### Step 1. Generate key and certificate

Before launching the test, you must have a keystore for the private key and the certificate associated with it. To generate the keystore, execute the instructions found in **src/main/security/createKeystore.sh** or with the following commands:

**Optional**: If you want to encrypt your container, put a password in an environment variable.

```shell
export KEY_PASSWORD=your_super_secure_password
```

**Optional**: If you want to encrypt your keystore, put a password in an environment variable.

```shell
export KEYSTORE_PASSWORD=your_super_secure_keystore_password
```

- Definition of file names and aliases.

```shell
export PRIVATE_KEY_FILE=pri_key.pem
export CERTIFICATE_FILE=certificate.pem
export SUBJECT=/C=MX/ST=MX/L=MX/O=CDC/CN=CDC
export PKCS12_FILE=keypair.p12
export KEYSTORE_FILE=keystore.jks
export ALIAS=cdc
```
- Generate key and certificate.

```shell
# Generate private key.
openssl ecparam -name secp384r1 -genkey -out ${PRIVATE_KEY_FILE}

# Generate public key
openssl req -new -x509 -days 365 \
  -key ${PRIVATE_KEY_FILE} \
  -out ${CERTIFICATE_FILE} \
  -subj "${SUBJECT}"

```

- Generate PKCS12 container from private key and certificate

```shell
# Generate PKCS12 container from private key and certificate
# You will need to package your private key and certificate.

openssl pkcs12 -name ${ALIAS} \
  -export -out ${PKCS12_FILE} \
  -inkey ${PRIVATE_KEY_FILE} \
  -in ${CERTIFICATE_FILE} \
  -password pass:${KEY_PASSWORD}

```

- Generate a dummy keystore and delete its content.

```sh
#Generate a Keystore with a pair of dummy keys.
keytool -genkey -alias dummy -keyalg RSA \
    -keysize 2048 -keystore ${KEYSTORE_FILE} \
    -dname "CN=dummy, OU=, O=, L=, S=, C=" \
    -storepass ${KEYSTORE_PASSWORD} -keypass ${KEY_PASSWORD}
#Remove the dummy key pair.
keytool -delete -alias dummy \
    -keystore ${KEYSTORE_FILE} \
    -storepass ${KEYSTORE_PASSWORD}
```

- Import the PKCS12 container to the keystore

```sh
#We import the PKCS12 container
keytool -importkeystore -srckeystore ${PKCS12_FILE} \
  -srcstoretype PKCS12 \
  -srcstorepass ${KEY_PASSWORD} \
  -destkeystore ${KEYSTORE_FILE} \
  -deststoretype JKS -storepass ${KEYSTORE_PASSWORD} \
  -alias ${ALIAS}
#List the contents of the Kesystore to verify that
keytool -list -keystore ${KEYSTORE_FILE} \
  -storepass ${KEYSTORE_PASSWORD}
```

### Step 2.  Uploading the certificate within the developer portal

 1. Login.
 2. Click on the section "**Mis aplicaciones**".
 3. Select the application.
 4. Go to the tab "**Certificados para @tuApp**".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/applications.png">
    </p>
 5. When the window opens, select the previously created certificate and click the button "**Cargar**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/upload_cert.png">
    </p>

### Step 3.  Download the C??rculo de Cr??dito certificate within the developer portal

 1. Login.
 2. Click on the section "**Mis aplicaciones**".
 3. Select the application.
 4. Go to the tab "**Certificados para @tuApp**".
    <p align="center">
        <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/applications.png">
    </p>
 5. When the window opens, click the button "**Descargar**":
    <p align="center">
        <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/download_cert.png">
    </p>

### Step 4. Modify configuration file

To make use of the certificate that was downloaded and the keystore that was created, the routes found in ***src/test/java/io/AdaSimulacion/client/api/AdaApiForBankDataAggregationsApiTes.java***
```properties
	private String certFile = "/your_path_for_certificate_of_cdc/certificate.pem";
	private String privateKeyPath = "/your_path_for_your_keystore/keystore.jks";
	private String keystorePassword = "your_super_secure_keystore_password";
	private String keyPassword = "your_super_secure_key_password";
	private String keyAlias = "cdc";
```
### Step 5. Modify URL and request data

In the WebHookSubscriptionsApiTest.java file, found at ***src/test/java/io/AdaSimulacion/client/api/AdaApiForBankDataAggregationsApiTes.java***. The request and URL data for API consumption must be modified in setBasePath ("the_url"), as shown in the following code snippet with the corresponding data:


> **NOTE:** The data in the following request is only representative.

```java
public class AdaApiForBankDataAggregationApiTest {

	private final AdaApiForBankDataAggregationApi ada = new AdaApiForBankDataAggregationApi();
	private Logger logger = LoggerFactory.getLogger(AdaApiForBankDataAggregationApiTest.class.getName());
	private ApiClient apiClient = null;
	private String xApiKey = "your_api_key";
	private String certFile = "/your_path_for_certificate_of_cdc/certificate.pem";
	private String privateKeyPath = "/your_path_for_your_keystore/keystore.jks";
	private String keystorePassword = "your_super_secure_keystore_password";
	private String keyPassword = "your_super_secure_key_password";
	private String keyAlias = "cdc";
	private UUID subscriptionId = UUID.fromString("uuid");
	private UUID inquiryId = null;

	@Before
	public void setUp() {
		this.apiClient = ada.getApiClient();
		this.apiClient.setBasePath("the_url");
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
		apiClient.setHttpClient(okHttpClient);
	}

	@Test
	public void postBankDataAggregationTest() throws ApiException {
		AckADARequest adaResponse = null;
		BankDataAggregation request = new BankDataAggregation();
		request.setBankDataAggregationRequestId(UUID.randomUUID());
		request.setSubscriptionId(subscriptionId);
		request.setCurp("SEPJ910101HVZNNL66");
		adaResponse = ada.postBankDataAggregation(xApiKey, request);

		logger.debug(adaResponse.toString());
		Assert.assertNotNull(adaResponse);
		inquiryId = adaResponse.getInquiryId();
		logger.info(inquiryId.toString());

		// List all the inquiryId available
		String page = null;
		String perPage = null;
		OffsetDateTime startAt = null;
		OffsetDateTime endAt = null;
		String inquiryStatus = null;
		String successCheck = null;
		Boolean flag = true;
		BankDataAggregationMetadata inquiriesResponse = ada.getBankDataAggregations(xApiKey, page, perPage, startAt,
				endAt, inquiryStatus, successCheck);
		logger.debug(inquiriesResponse.toString());
		List<BankDataAggregation> inquiries = inquiriesResponse.getInquiries();
		for (BankDataAggregation bda : inquiries) {
			if (inquiryId.equals(bda.getInquiryId())) {
				logger.debug("inquiryId is in the list");
				Assert.assertNotNull(bda.getInquiryId());
				flag = false;
			}
		}
		if (flag) {
			logger.debug("inquiryId not found");
		}

		// Get inquiryId status
		String xPublicKey = KeyHandler.getB64fromFile(certFile);
		ApiResponse<AckSuccessADAConsumption> rawResponse = ada.getInquiry(xApiKey, xPublicKey, inquiryId.toString());
		AckSuccessADAConsumption response = rawResponse.getData();
		Map<String, List<String>> headers = rawResponse.getHeaders();
		logger.debug(response.toString());
		String ct = (String) response.getBankDataAggregation().getPayload();
		String iv = headers.get("x-iv").get(0);
		String publicCDC = headers.get("x-public-key-cdc").get(0);

		try {
			ECDHAlgCipher cipher = new ECDHAlgCipher(publicCDC, privateKeyPath, keystorePassword, keyPassword,
					keyAlias);
			String payloadStr = cipher.decryptString(ct, iv);
			logger.info(payloadStr);
		} catch (IOException e) {
			logger.error("Could not decrypt the payload field");
		}
	}

	@Test
	public void postConfBankDataAggregationTest() throws ApiException {
		BankDataAggregationConfiguration request = new BankDataAggregationConfiguration();
		ConfigurationRequestPrincipal principal = new ConfigurationRequestPrincipal();
		ConfigurationRequestDescriptions descriptions = new ConfigurationRequestDescriptions();
		ConfigurationRequestTermsAndConditions terms = new ConfigurationRequestTermsAndConditions();
		ConfigurationRequest configuration = new ConfigurationRequest();

		principal.setUserName("C??rculo de Cr??dito");
		principal.setAuthorizationStatement("INT (CIF: ) solicita su permiso para realizar las siguientes acciones:");
		principal.setUserLogo("data:image/png;base64, userlobase64");
		principal.setPrimaryColor("#0E1D36");
		principal.setSecondaryColor("#ECB330");

		descriptions.setFirstHighlightedText("Cumplimos con la directiva Europea PSD2.");
		descriptions.setFirstHighlightedIcon(Icons.FAR_FA_STAR);
		descriptions.setSecondHighlightedText("Sus datos son encriptados con la ??ltima tecnolog??a.");
		descriptions.setSecondHighlightedIcon(Icons.FAS_FA_CREDIT_CARD);
		descriptions.setThirdHighlightedText(
				"Sus datos personales est??n regulados por la Ley Org??nica de Protecci??n de Datos de Car??cter Personal (GDPR).");
		descriptions.setThirdHighlightedIcon(Icons.FAS_FA_KEY);

		terms.setTermsAndConditionsTitle("Terminos y condiciones");
		terms.setTermsAndConditionsLabel(
				"Al continuar, acepto y confirmo que he leido los terminos y condiciones. Que los entiendo, acepto y quedo vinculado por ellos");
		terms.setTermsAndConditions(
				"<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vehicula tellus sed faucibus lacinia. Aenean faucibus, est in sollicitudin dapibus, justo velit venenatis magna, et aliquet lacus turpis sed nisl. Vestibulum maximus ante mi, vitae congue ipsum mollis vitae. Integer non sem ornare, hendrerit risus in, egestas tellus. Nam orci lectus, scelerisque nec commodo nec, suscipit ut nisl. Ut eu euismod erat, a dictum mi. Etiam aliquam neque nec hendrerit faucibus. Phasellus placerat finibus porta.</p><p>Nunc faucibus arcu nec metus euismod congue. Maecenas rutrum justo elit. Nunc viverra elementum semper. Proin scelerisque, sem id aliquam semper, erat orci volutpat leo, eget suscipit lectus velit id velit. Proin mattis in quam nec tristique. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nam ut mi ligula.</p><p>Pellentesque elementum neque et dui consequat convallis. Aliquam blandit non urna vel ultrices. Curabitur viverra gravida nunc eu auctor. Maecenas ac efficitur enim. Etiam molestie id nulla ut volutpat. Praesent eu dui ac sem volutpat commodo. Suspendisse convallis cursus mollis. Suspendisse condimentum lorem varius, pharetra neque sed, mattis arcu. In feugiat, nibh ac vestibulum varius, libero risus tempus nulla, sed convallis nulla neque ut velit. Mauris sed metus ligula. Vivamus molestie vehicula felis, nec aliquet justo rutrum sit amet. Pellentesque et efficitur tellus, in pretium sem. Donec euismod orci nisl, ut imperdiet risus fringilla eget. Aliquam accumsan et ipsum sed convallis. Curabitur eros nisi, porta ac lorem vel, viverra venenatis mauris.</p><p>Fusce aliquet turpis sed dui luctus molestie. Maecenas eget metus dignissim, consequat orci eget, gravida augue. Sed porttitor nibh erat, eu tempor enim pharetra in. Sed vehicula, dolor id ultricies faucibus, nunc erat elementum mi, in gravida augue elit quis libero. Nulla ac ex et tortor dictum iaculis fringilla id quam. In feugiat leo vel est iaculis, non accumsan purus gravida. Vivamus orci augue, dignissim ac pulvinar sit amet, blandit pulvinar ante. Suspendisse pellentesque nibh eget dignissim faucibus. Pellentesque eu pellentesque tortor. Fusce efficitur ligula ligula.</p><p>Aenean rhoncus elit id nibh porttitor, in dictum lectus porttitor. Mauris metus nulla, rhoncus at odio in, mollis porta urna. Sed vestibulum eros malesuada nulla varius, sit amet viverra est consectetur. Cras fringilla ornare sagittis. Ut et erat eu odio pulvinar dapibus nec sit amet risus. Nam blandit mollis urna, quis tincidunt diam ultricies non. Suspendisse id libero suscipit, viverra ligula nec, viverra odio.</p>");

		configuration.setPrincipal(principal);
		configuration.setDescriptions(descriptions);
		configuration.setTermsAndConditions(terms);

		request.setSubscriptionId(subscriptionId);
		request.setConfiguration(configuration);

		AckBankDataAggregation response = ada.postConfBankDataAggregation(xApiKey, request);
		logger.info(response.toString());
	}

	@Test
	public void getConfBankDataAggregationTest() throws ApiException {
		BankDataAggregationConfigurationResponse response = ada.getConfBankDataAggregation(xApiKey, subscriptionId);
		logger.info(response.toString());
	}

}

```
### Step 6. Run the unit test

Having the previous steps, all that remains is to run the unit test, with the following command:
```shell
mvn test -Dmaven.install.skip=true
```


---
[TERMS AND CONDITIONS](https://github.com/APIHub-CdC/licencias-cdc)