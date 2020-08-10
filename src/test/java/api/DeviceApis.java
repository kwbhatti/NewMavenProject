package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.devices.DeviceNotes;
import models.devices.DeviceTag;
import utils.BaseClass;

import static io.restassured.RestAssured.given;

public class DeviceApis extends BaseClass {

    public static final String DEVICE_ENDPOINT = "/devices/";
    public static final String DEVICE_ALL_TAGS = "tags/";
    public static final String LOAD_BALANCER_RULE = "loadbalancer-rules?_id=";

    public static final String DEVICE_HARDWARE = "hardware/connected?_id=";
    public static final String USER_FOR_DEVICE = "users?_id=";


    public static Response getAllDevices() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/getAllDevices?page=0&size=10");
    }

    public static Response getDevicesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/deviceDetail?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getDeviceAdaptersListById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/adapters/list?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getDrivesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/drives?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getOSPatchesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/os/patches/installed?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getRunningProcessesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/processes/running?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getInstalledSoftwareDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/software/installed?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getOSDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/os/info?_id=" + DEVICE_DETAIL_ID);

    }

    public static Response getUserDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/users?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getNetworkInterfacesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/network/interfaces?_id=" + DEVICE_DETAIL_ID);

    }

    public static Response getSharedFoldersDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/shared/folders?_id=" + DEVICE_DETAIL_ID);

    }

    public static Response getDeviceNoteDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/getDeviceNote?deviceId=" + DEVICE_DETAIL_ID);

    }
    public static Response getDeviceTagDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/getDeviceTag?deviceId=" + DEVICE_DETAIL_ID);

    }
    public static Response getGeneralDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/general?_id=" + DEVICE_DETAIL_ID);

    }
    public static Response getAdapterDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/devices/adapter/data?_id=" + DEVICE_DETAIL_ID + "&adapter");

    }

    public static Response getAllTags() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + DEVICE_ENDPOINT + DEVICE_ALL_TAGS);

    }

    public static Response getLoadBalancerRulesForDevice() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + DEVICE_ENDPOINT + LOAD_BALANCER_RULE + DEVICE_DETAIL_ID);

    }

    public static Response getConnectedHardwareForDevice() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + DEVICE_ENDPOINT + DEVICE_HARDWARE + DEVICE_DETAIL_ID);

    }

    public static Response getUsersForDevice() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + DEVICE_ENDPOINT + USER_FOR_DEVICE + DEVICE_DETAIL_ID);

    }

    public static Response postInsertDeviceNote(DeviceNotes deviceNotes) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(deviceNotes)
                .when()
                .post(BASE_ENDPOINT + "/devices/insertNote");

    }

    public static Response postInsertDeviceTag(DeviceTag deviceTag) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(deviceTag)
                .when()
                .post(BASE_ENDPOINT + "/devices/insertTag");

    }


}
