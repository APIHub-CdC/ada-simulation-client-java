package io.AdaSimulacion.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.threeten.bp.OffsetDateTime;

import com.google.gson.reflect.TypeToken;

import io.AdaSimulacion.client.ApiClient;
import io.AdaSimulacion.client.ApiException;
import io.AdaSimulacion.client.ApiResponse;
import io.AdaSimulacion.client.Configuration;
import io.AdaSimulacion.client.Pair;
import io.AdaSimulacion.client.ProgressRequestBody;
import io.AdaSimulacion.client.ProgressResponseBody;
import io.AdaSimulacion.client.model.AckADARequest;
import io.AdaSimulacion.client.model.AckBankDataAggregation;
import io.AdaSimulacion.client.model.AckSuccessADAConsumption;
import io.AdaSimulacion.client.model.BankDataAggregation;
import io.AdaSimulacion.client.model.BankDataAggregationConfiguration;
import io.AdaSimulacion.client.model.BankDataAggregationConfigurationResponse;
import io.AdaSimulacion.client.model.BankDataAggregationMetadata;

public class AdaApiForBankDataAggregationApi {
	private ApiClient apiClient;

	public AdaApiForBankDataAggregationApi() {
		this(Configuration.getDefaultApiClient());
	}

	public AdaApiForBankDataAggregationApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public okhttp3.Call getBankDataAggregationsCall(String xApiKey, String page, String perPage, OffsetDateTime startAt,
			OffsetDateTime endAt, String inquiryStatus, String successCheck,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;
		String localVarPath = "/bankdataaggregations";
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (page != null)
			localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
		if (perPage != null)
			localVarQueryParams.addAll(apiClient.parameterToPair("perPage", perPage));
		if (startAt != null)
			localVarQueryParams.addAll(apiClient.parameterToPair("startAt", startAt));
		if (endAt != null)
			localVarQueryParams.addAll(apiClient.parameterToPair("endAt", endAt));
		if (inquiryStatus != null)
			localVarQueryParams.addAll(apiClient.parameterToPair("inquiryStatus", inquiryStatus));
		if (successCheck != null)
			localVarQueryParams.addAll(apiClient.parameterToPair("successCheck", successCheck));
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call getBankDataAggregationsValidateBeforeCall(String xApiKey, String page, String perPage,
			OffsetDateTime startAt, OffsetDateTime endAt, String inquiryStatus, String successCheck,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException(
					"Missing the required parameter 'xApiKey' when calling getBankDataAggregations(Async)");
		}

		okhttp3.Call call = getBankDataAggregationsCall(xApiKey, page, perPage, startAt, endAt, inquiryStatus,
				successCheck, progressListener, progressRequestListener);
		return call;
	}

	public BankDataAggregationMetadata getBankDataAggregations(String xApiKey, String page, String perPage,
			OffsetDateTime startAt, OffsetDateTime endAt, String inquiryStatus, String successCheck)
			throws ApiException {
		ApiResponse<BankDataAggregationMetadata> resp = getBankDataAggregationsWithHttpInfo(xApiKey, page, perPage,
				startAt, endAt, inquiryStatus, successCheck);
		return resp.getData();
	}

	public ApiResponse<BankDataAggregationMetadata> getBankDataAggregationsWithHttpInfo(String xApiKey, String page,
			String perPage, OffsetDateTime startAt, OffsetDateTime endAt, String inquiryStatus, String successCheck)
			throws ApiException {
		okhttp3.Call call = getBankDataAggregationsValidateBeforeCall(xApiKey, page, perPage, startAt, endAt,
				inquiryStatus, successCheck, null, null);
		Type localVarReturnType = new TypeToken<BankDataAggregationMetadata>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	public okhttp3.Call getConfBankDataAggregationCall(String xApiKey, UUID subscriptionId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;
		String localVarPath = "/configurations/{subscriptionId}".replaceAll("\\{" + "subscriptionId" + "\\}",
				apiClient.escapeString(subscriptionId.toString()));
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call getConfBankDataAggregationValidateBeforeCall(String xApiKey, UUID subscriptionId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException(
					"Missing the required parameter 'xApiKey' when calling getConfBankDataAggregation(Async)");
		}
		if (subscriptionId == null) {
			throw new ApiException(
					"Missing the required parameter 'subscriptionId' when calling getConfBankDataAggregation(Async)");
		}

		okhttp3.Call call = getConfBankDataAggregationCall(xApiKey, subscriptionId, progressListener,
				progressRequestListener);
		return call;
	}

	public BankDataAggregationConfigurationResponse getConfBankDataAggregation(String xApiKey, UUID subscriptionId)
			throws ApiException {
		ApiResponse<BankDataAggregationConfigurationResponse> resp = getConfBankDataAggregationWithHttpInfo(xApiKey,
				subscriptionId);
		return resp.getData();
	}

	public ApiResponse<BankDataAggregationConfigurationResponse> getConfBankDataAggregationWithHttpInfo(String xApiKey,
			UUID subscriptionId) throws ApiException {
		okhttp3.Call call = getConfBankDataAggregationValidateBeforeCall(xApiKey, subscriptionId, null, null);
		Type localVarReturnType = new TypeToken<BankDataAggregationConfigurationResponse>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	public okhttp3.Call getInquiryCall(String xApiKey, String xPublicKey, String inquiryId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;
		String localVarPath = "/bankdataaggregations/{inquiryId}".replaceAll("\\{" + "inquiryId" + "\\}",
				apiClient.escapeString(inquiryId.toString()));
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		if (xPublicKey != null)
			localVarHeaderParams.put("x-public-key", apiClient.parameterToString(xPublicKey));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call getInquiryValidateBeforeCall(String xApiKey, String xPublicKey, String inquiryId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException("Missing the required parameter 'xApiKey' when calling getInquiry(Async)");
		}
		if (xPublicKey == null) {
			throw new ApiException("Missing the required parameter 'xPublicKey' when calling getInquiry(Async)");
		}
		if (inquiryId == null) {
			throw new ApiException("Missing the required parameter 'inquiryId' when calling getInquiry(Async)");
		}

		okhttp3.Call call = getInquiryCall(xApiKey, xPublicKey, inquiryId, progressListener, progressRequestListener);
		return call;
	}

	public ApiResponse<AckSuccessADAConsumption> getInquiry(String xApiKey, String xPublicKey, String inquiryId)
			throws ApiException {
		ApiResponse<AckSuccessADAConsumption> resp = getInquiryWithHttpInfo(xApiKey, xPublicKey, inquiryId);
		return resp;
	}

	public ApiResponse<AckSuccessADAConsumption> getInquiryWithHttpInfo(String xApiKey, String xPublicKey,
			String inquiryId) throws ApiException {
		okhttp3.Call call = getInquiryValidateBeforeCall(xApiKey, xPublicKey, inquiryId, null, null);
		Type localVarReturnType = new TypeToken<AckSuccessADAConsumption>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	public okhttp3.Call postBankDataAggregationCall(String xApiKey, BankDataAggregation request,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = request;
		String localVarPath = "/bankdataaggregations";
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call postBankDataAggregationValidateBeforeCall(String xApiKey, BankDataAggregation request,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException(
					"Missing the required parameter 'xApiKey' when calling postBankDataAggregation(Async)");
		}
		if (request == null) {
			throw new ApiException(
					"Missing the required parameter 'request' when calling postBankDataAggregation(Async)");
		}

		okhttp3.Call call = postBankDataAggregationCall(xApiKey, request, progressListener, progressRequestListener);
		return call;
	}

	public AckADARequest postBankDataAggregation(String xApiKey, BankDataAggregation request) throws ApiException {
		ApiResponse<AckADARequest> resp = postBankDataAggregationWithHttpInfo(xApiKey, request);
		return resp.getData();
	}

	public ApiResponse<AckADARequest> postBankDataAggregationWithHttpInfo(String xApiKey, BankDataAggregation request)
			throws ApiException {
		okhttp3.Call call = postBankDataAggregationValidateBeforeCall(xApiKey, request, null, null);
		Type localVarReturnType = new TypeToken<AckADARequest>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	public okhttp3.Call postConfBankDataAggregationCall(String xApiKey, BankDataAggregationConfiguration request,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = request;
		String localVarPath = "/configurations";
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call postConfBankDataAggregationValidateBeforeCall(String xApiKey,
			BankDataAggregationConfiguration request, final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException(
					"Missing the required parameter 'xApiKey' when calling postConfBankDataAggregation(Async)");
		}
		if (request == null) {
			throw new ApiException(
					"Missing the required parameter 'request' when calling postConfBankDataAggregation(Async)");
		}

		okhttp3.Call call = postConfBankDataAggregationCall(xApiKey, request, progressListener,
				progressRequestListener);
		return call;
	}

	public AckBankDataAggregation postConfBankDataAggregation(String xApiKey, BankDataAggregationConfiguration request)
			throws ApiException {
		ApiResponse<AckBankDataAggregation> resp = postConfBankDataAggregationWithHttpInfo(xApiKey, request);
		return resp.getData();
	}

	public ApiResponse<AckBankDataAggregation> postConfBankDataAggregationWithHttpInfo(String xApiKey,
			BankDataAggregationConfiguration request) throws ApiException {
		okhttp3.Call call = postConfBankDataAggregationValidateBeforeCall(xApiKey, request, null, null);
		Type localVarReturnType = new TypeToken<AckBankDataAggregation>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}
}
