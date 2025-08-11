package org.aziza.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.aziza.project.di.initKoin
import org.aziza.project.presentation.screen.sdui.HomeScreenSDUI
import org.aziza.project.presentation.screen.sdui_v2.CoinsScreenSDUI
import org.aziza.project.sdk.HomeScreenConfig

@Composable
fun App(config: HomeScreenConfig) {
    remember { initKoin() }
    MaterialTheme {
//        HomeScreenSDUI { screenId, extras ->
//            println("Screen Id:$screenId")
//            println("Extras:$extras")
//        }
        val sampleJson = """
      {
    "data": {
      "customerProfileResponse": {
        "status": "true",
        "responseAttributes": {
          "responseAttribute": [
            {
              "attributeValue": {
                "value": "The more coins you win, the bigger the gift will be!"
              },
              "key": "COINS_DESC"
            },
            {
              "attributeValue": {
                "value": "230"
              },
              "key": "COINS"
            },
            {
              "attributeValue": {
                "value": "true"
              },
              "key": "IS_SUBSCRIBED"
            },
            {
              "attributeValue": {
                "value": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/true.png"
              },
              "key": "IMAGE_URL"
            }
          ]
        },
        "Categories": {
          "Category": [
            {
              "categoryDesc": "Telecom",
              "categoryId": "Telecom",
              "categoryImg": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Telecom_COINS_EN.png",
              "categoryTitle": "Telecom",
              "products": {
                "product": [
                  {
                    "subProducts": {
                      "subProduct": [
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "10"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/FB_15563.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "190"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "100"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "FB",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Facebook Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "15"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/FB_15563.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "370"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "160"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "FB",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Facebook Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "20"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/FB_15563.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "680"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "280"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "FB",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Facebook Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "25"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/FB_15563.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "1000"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "400"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "FB",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Facebook Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "30"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/FB_15563.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "1"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "1510"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "550"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "FB",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Facebook Megabytes"
                        }
                      ]
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_FACEBOOK.png",
                    "longDesc": "100-550",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_FACEBOOK",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Facebook Megabytes",
                    "subscriptionSteps": "",
                    "title": "Facebook Megabytes"
                  },
                  {
                    "subProducts": {
                      "subProduct": [
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "85"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Youtube_15565.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "190"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "100"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Youtube",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Youtube Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "90"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Youtube_15565.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "370"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "160"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Youtube",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Youtube Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "95"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Youtube_15565.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "680"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "280"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Youtube",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Youtube Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "100"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Youtube_15565.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "1000"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "400"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Youtube",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Youtube Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "105"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Youtube_15565.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "1"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "1510"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "550"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Youtube",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Youtube Megabytes"
                        }
                      ]
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_YOUTUBE.png",
                    "longDesc": "100-550",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_YOUTUBE",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Youtube Megabytes",
                    "subscriptionSteps": "",
                    "title": "Youtube Megabytes"
                  },
                  {
                    "subProducts": {
                      "subProduct": [
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "60"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Instagram_15592.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "190"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "100"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Instagram",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Instagram Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "65"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Instagram_15592.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "370"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "160"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Instagram",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Instagram Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "70"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Instagram_15592.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "680"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "280"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Instagram",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Instagram Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "75"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Instagram_15592.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "1000"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "400"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Instagram",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Instagram Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "80"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Instagram_15592.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "1"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "1510"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "550"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Instagram",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Instagram Megabytes"
                        }
                      ]
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_INSTAGRAM.png",
                    "longDesc": "100-550",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_INSTAGRAM",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Instagram Megabytes",
                    "subscriptionSteps": "",
                    "title": "Instagram Megabytes"
                  },
                  {
                    "subProducts": {
                      "subProduct": [
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "135"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/MBs_15749.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "200"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "125"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "MBs",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "140"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/MBs_15749.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "390"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "250"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "MBs",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "145"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/MBs_15749.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "660"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "400"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "MBs",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "150"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/MBs_15749.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "990"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "600"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "MBs",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "155"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/MBs_15749.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "1"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "1310"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "750"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "MBs",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Megabytes"
                        }
                      ]
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_MEGABYTE.png",
                    "longDesc": "125-750",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_MEGABYTE",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Megabytes",
                    "subscriptionSteps": "",
                    "title": "Megabytes"
                  },
                  {
                    "subProducts": {
                      "subProduct": [
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "35"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/TikTok_15564.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "190"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "100"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "TikTok",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "TikTok Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "40"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/TikTok_15564.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "370"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "160"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "TikTok",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "TikTok Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "45"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/TikTok_15564.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "680"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "280"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "TikTok",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "TikTok Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "50"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/TikTok_15564.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "1000"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "400"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "TikTok",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "TikTok Megabytes"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "55"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/TikTok_15564.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "1"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "1510"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "550"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "TikTok",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "TikTok Megabytes"
                        }
                      ]
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_TIKTOK.png",
                    "longDesc": "100-550",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_TIKTOK",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "TikTok Megabytes",
                    "subscriptionSteps": "",
                    "title": "TikTok Megabytes"
                  },
                  {
                    "subProducts": {
                      "subProduct": [
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "156"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Social Minutes_15750.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "25"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "120"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Social Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Social Mins"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "161"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Social Minutes_15750.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "55"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "200"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Social Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Social Mins"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "166"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Social Minutes_15750.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "105"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "350"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Social Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Social Mins"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "171"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Social Minutes_15750.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "155"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "500"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Social Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Social Mins"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "176"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Social Minutes_15750.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "1"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "230"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "700"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Social Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Social Mins"
                        }
                      ]
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_SOCIAL.png",
                    "longDesc": "120-700",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_SOCIAL",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Social Minutes",
                    "subscriptionSteps": "",
                    "title": "Social Minutes"
                  },
                  {
                    "subProducts": {
                      "subProduct": [
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "181"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Streaming Minutes_15751.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "25"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "120"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Streaming Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Streaming Mins"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "186"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Streaming Minutes_15751.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "55"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "200"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Streaming Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Streaming Mins"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "191"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Streaming Minutes_15751.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "105"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "350"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Streaming Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Streaming Mins"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "196"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Streaming Minutes_15751.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "155"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "500"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Streaming Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Streaming Mins"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "201"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Streaming Minutes_15751.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "1"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "230"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "700"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Streaming Minutes",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "Streaming Mins"
                        }
                      ]
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_STREAMING.png",
                    "longDesc": "120-700",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_STREAMING",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Streaming Minutes",
                    "subscriptionSteps": "",
                    "title": "Streaming Minutes"
                  }
                ]
              }
            },
            {
              "categoryDesc": "Cash",
              "categoryId": "Cash",
              "categoryImg": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Cash_COINS_EN.png",
              "categoryTitle": "Cash",
              "products": {
                "product": {
                  "subProducts": {
                    "subProduct": [
                      {
                        "parameters": {
                          "parameter": {
                            "name": "GIFT_ID",
                            "value": "206"
                          }
                        },
                        "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Cash_15798.png",
                        "attributes": {
                          "attribute": [
                            {
                              "attributeValue": {
                                "value": "6"
                              },
                              "key": "GIFT_VALIDITY"
                            },
                            {
                              "attributeValue": {
                                "value": "30"
                              },
                              "key": "QUOTA"
                            },
                            {
                              "attributeValue": {
                                "value": "400"
                              },
                              "key": "GIFT_FEES"
                            }
                          ]
                        },
                        "productId": "Cash",
                        "productStatus": "UN_DEFINED",
                        "subscriptionSteps": "",
                        "title": "EGP"
                      },
                      {
                        "parameters": {
                          "parameter": {
                            "name": "GIFT_ID",
                            "value": "207"
                          }
                        },
                        "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Cash_15798.png",
                        "attributes": {
                          "attribute": [
                            {
                              "attributeValue": {
                                "value": "6"
                              },
                              "key": "GIFT_VALIDITY"
                            },
                            {
                              "attributeValue": {
                                "value": "80"
                              },
                              "key": "QUOTA"
                            },
                            {
                              "attributeValue": {
                                "value": "800"
                              },
                              "key": "GIFT_FEES"
                            }
                          ]
                        },
                        "productId": "Cash",
                        "productStatus": "UN_DEFINED",
                        "subscriptionSteps": "",
                        "title": "EGP"
                      }
                    ]
                  },
                  "fees": "0.0",
                  "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_CASHBACK.png",
                  "longDesc": "400-800",
                  "operations": {
                    "operation": {
                      "operationCategories": "",
                      "operationId": "REDEEM",
                      "operationName": "Redeem",
                      "operationOrder": "0"
                    }
                  },
                  "productId": "BTS_CASHBACK",
                  "productStatus": "UN_DEFINED",
                  "shortDesc": "Cash",
                  "subscriptionSteps": "",
                  "title": "Cash"
                }
              }
            },
            {
              "categoryDesc": "Voucher",
              "categoryId": "Voucher",
              "categoryImg": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Voucher_COINS_EN.png",
              "categoryTitle": "Voucher",
              "products": {
                "product": [
                  {
                    "subProducts": {
                      "subProduct": [
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "218"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/E-shop Absolute Voucher_15796.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "50"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "500"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "E-shop Absolute Voucher",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "E-shop Voucher"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "219"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/E-shop Absolute Voucher_15796.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "100"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "750"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "E-shop Absolute Voucher",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "E-shop Voucher"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "220"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/E-shop Absolute Voucher_15796.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "150"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "1000"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "E-shop Absolute Voucher",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "E-shop Voucher"
                        }
                      ]
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_ESHOP.png",
                    "longDesc": "500-1000",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_ESHOP",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "E-shop Voucher",
                    "subscriptionSteps": "",
                    "title": "E-shop Voucher"
                  },
                  {
                    "subProducts": {
                      "subProduct": [
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "224"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Waffarha Absolute Voucher_15800.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "20"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "400"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Waffarha Absolute Voucher",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "World of Deals"
                        },
                        {
                          "parameters": {
                            "parameter": {
                              "name": "GIFT_ID",
                              "value": "225"
                            }
                          },
                          "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Waffarha Absolute Voucher_15800.png",
                          "attributes": {
                            "attribute": [
                              {
                                "attributeValue": {
                                  "value": "0"
                                },
                                "key": "GIFT_VALIDITY"
                              },
                              {
                                "attributeValue": {
                                  "value": "50"
                                },
                                "key": "QUOTA"
                              },
                              {
                                "attributeValue": {
                                  "value": "750"
                                },
                                "key": "GIFT_FEES"
                              }
                            ]
                          },
                          "productId": "Waffarha Absolute Voucher",
                          "productStatus": "UN_DEFINED",
                          "subscriptionSteps": "",
                          "title": "World of Deals"
                        }
                      ]
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_WAFFARHA.png",
                    "longDesc": "400-750",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_WAFFARHA",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "World of deals",
                    "subscriptionSteps": "",
                    "title": "World of deals"
                  }
                ]
              }
            },
            {
              "categoryDesc": "Entertainment",
              "categoryId": "Entertainment",
              "categoryImg": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Entertainment_COINS_EN.png",
              "categoryTitle": "Entertainment",
              "products": {
                "product": [
                  {
                    "subProducts": {
                      "subProduct": {
                        "parameters": {
                          "parameter": {
                            "name": "GIFT_ID",
                            "value": "234"
                          }
                        },
                        "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Twist TV_15597.png",
                        "attributes": {
                          "attribute": [
                            {
                              "attributeValue": {
                                "value": "29"
                              },
                              "key": "GIFT_VALIDITY"
                            },
                            {
                              "attributeValue": {
                                "value": ""
                              },
                              "key": "QUOTA"
                            },
                            {
                              "attributeValue": {
                                "value": "20"
                              },
                              "key": "GIFT_FEES"
                            }
                          ]
                        },
                        "productId": "Twist TV",
                        "productStatus": "UN_DEFINED",
                        "subscriptionSteps": "",
                        "title": "Twist TV"
                      }
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_TWIST_TV.png",
                    "longDesc": "20",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_TWIST_TV",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Twist TV",
                    "subscriptionSteps": "",
                    "title": "Twist TV"
                  },
                  {
                    "subProducts": {
                      "subProduct": {
                        "parameters": {
                          "parameter": {
                            "name": "GIFT_ID",
                            "value": "235"
                          }
                        },
                        "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Twist Music_15601.png",
                        "attributes": {
                          "attribute": [
                            {
                              "attributeValue": {
                                "value": "29"
                              },
                              "key": "GIFT_VALIDITY"
                            },
                            {
                              "attributeValue": {
                                "value": ""
                              },
                              "key": "QUOTA"
                            },
                            {
                              "attributeValue": {
                                "value": "15"
                              },
                              "key": "GIFT_FEES"
                            }
                          ]
                        },
                        "productId": "Twist Music",
                        "productStatus": "UN_DEFINED",
                        "subscriptionSteps": "",
                        "title": "Twist Music"
                      }
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_TWIST_MUSIC.png",
                    "longDesc": "15",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_TWIST_MUSIC",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Twist Music",
                    "subscriptionSteps": "",
                    "title": "Twist Music"
                  },
                  {
                    "subProducts": {
                      "subProduct": {
                        "parameters": {
                          "parameter": {
                            "name": "GIFT_ID",
                            "value": "236"
                          }
                        },
                        "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Viu_15595.png",
                        "attributes": {
                          "attribute": [
                            {
                              "attributeValue": {
                                "value": "29"
                              },
                              "key": "GIFT_VALIDITY"
                            },
                            {
                              "attributeValue": {
                                "value": ""
                              },
                              "key": "QUOTA"
                            },
                            {
                              "attributeValue": {
                                "value": "60"
                              },
                              "key": "GIFT_FEES"
                            }
                          ]
                        },
                        "productId": "Viu",
                        "productStatus": "UN_DEFINED",
                        "subscriptionSteps": "",
                        "title": "Viu"
                      }
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_VIU.png",
                    "longDesc": "60",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_VIU",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Viu",
                    "subscriptionSteps": "",
                    "title": "Viu"
                  },
                  {
                    "subProducts": {
                      "subProduct": {
                        "parameters": {
                          "parameter": {
                            "name": "GIFT_ID",
                            "value": "237"
                          }
                        },
                        "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Tod Mobile_15602.png",
                        "attributes": {
                          "attribute": [
                            {
                              "attributeValue": {
                                "value": "29"
                              },
                              "key": "GIFT_VALIDITY"
                            },
                            {
                              "attributeValue": {
                                "value": ""
                              },
                              "key": "QUOTA"
                            },
                            {
                              "attributeValue": {
                                "value": "450"
                              },
                              "key": "GIFT_FEES"
                            }
                          ]
                        },
                        "productId": "Tod Mobile",
                        "productStatus": "UN_DEFINED",
                        "subscriptionSteps": "",
                        "title": "TOD Mobile"
                      }
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_TOD.png",
                    "longDesc": "450",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_TOD",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Tod",
                    "subscriptionSteps": "",
                    "title": "Tod"
                  },
                  {
                    "subProducts": {
                      "subProduct": {
                        "parameters": {
                          "parameter": {
                            "name": "GIFT_ID",
                            "value": "238"
                          }
                        },
                        "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/Tod Monthly_15602.png",
                        "attributes": {
                          "attribute": [
                            {
                              "attributeValue": {
                                "value": "29"
                              },
                              "key": "GIFT_VALIDITY"
                            },
                            {
                              "attributeValue": {
                                "value": ""
                              },
                              "key": "QUOTA"
                            },
                            {
                              "attributeValue": {
                                "value": "750"
                              },
                              "key": "GIFT_FEES"
                            }
                          ]
                        },
                        "productId": "Tod Monthly",
                        "productStatus": "UN_DEFINED",
                        "subscriptionSteps": "",
                        "title": "TOD"
                      }
                    },
                    "fees": "0.0",
                    "itemImage": "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/BTS_TOD_MONTHLY.png",
                    "longDesc": "750",
                    "operations": {
                      "operation": {
                        "operationCategories": "",
                        "operationId": "REDEEM",
                        "operationName": "Redeem",
                        "operationOrder": "0"
                      }
                    },
                    "productId": "BTS_TOD_MONTHLY",
                    "productStatus": "UN_DEFINED",
                    "shortDesc": "Tod Monthly",
                    "subscriptionSteps": "",
                    "title": "Tod Monthly"
                  }
                ]
              }
            }
          ],
          "dataKey": "CATEGORIES"
        }
      }
    },
    "views": {
      "title": "Coins",
      "flowId": "CoinsRewardsScreen",
      "components": [
        {
          "type": "card_banner_coins",
          "style": "",
          "components": [
            {
              "type": "text_underline",
              "style": "head3",
              "dataKey": "History",
              "action": {
                "actionType": "screen_id",
                "screenId": "CoinsHistoryActivity",
                "link": "",
                "extras": [
                  {
                    "key": "EXTRA_HISTORY_SHOW_FILTER",
                    "value": "true"
                  },
                  {
                    "key": "EXTRA_HISTORY_REQUEST_TYPE",
                    "value": "INCEPTION_COINS_HISTORY"
                  }
                ]
              }
            },
            {
              "type": "icon",
              "style": "icon_button",
              "dataKey": "ic_info",
              "action": {
                "actionType": "link",
                "screenId": "",
                "link": "https://www.etisalat.eg/StaticFiles/MyEtisalat/Ramadan/Akwa_en.html",
                "extras": []
              }
            },
            {
              "type": "image",
              "dataKey": "img_coins"
            },
            {
              "type": "text",
              "style": "head2",
              "dataKey": "COINS"
            },
            {
              "type": "text",
              "style": "body_small_regular",
              "dataKey": "COINS_DESC"
            }
          ]
        },
        {
          "type": "card_my_gifts",
          "components": [
            {
              "type": "image",
              "dataKey": "gift_icon"
            },
            {
              "type": "text",
              "style": "head1",
              "dataKey": "My Gifts"
            },
            {
              "type": "icon",
              "style": "",
              "dataKey": "ic_arrow_forward",
              "action": {
                "actionType": "screen_id",
                "screenId": "MyUsageRevampedActivity",
                "link": "",
                "extras": [
                  {
                    "key": "CATEGORY_NAME",
                    "value": "COUPE_COINS"
                  },
                  {
                    "key": "SCREEN_TITLE",
                    "value": "My Gifts"
                  }
                ]
              }
            }
          ]
        },
        {
          "type": "list_expandable",
          "dataKey": "CATEGORIES",
          "components": [
            {
              "type": "row_arrangement_spacebetween",
              "components": [
                {
                  "type": "text",
                  "style": "head1",
                  "dataKey": "item.categoryTitle"
                },
                {
                  "type": "text",
                  "style": "badge_count",
                  "dataKey": ""
                }
              ]
            },
            {
              "type": "grid_vertical",
              "dataKey": "",
              "components": [
                {
                  "type": "image_async",
                  "dataKey": ""
                },
                {
                  "type": "text",
                  "style": "body",
                  "dataKey": ""
                },
                {
                  "type": "button_text_icon",
                  "style": "",
                  "dataKey": ""
                }
              ]
            }
          ]
        }
      ]
    }
  }
          """.trimIndent()
          CoinsScreenSDUI(sampleJson)
    }
}