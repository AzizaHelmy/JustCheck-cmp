package org.aziza.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.aziza.project.di.initKoin
import org.aziza.project.presentation.screen.sdui.HomeScreenSDUI
import org.aziza.project.presentation.screen.sdui_v2.CoinsScreenSDUI
import org.aziza.project.presentation.screen.sdui_v2.parseCoinsScreen
import org.aziza.project.sdk.HomeScreenConfig

@Composable
fun App(config: HomeScreenConfig) {
    remember { initKoin() }
    MaterialTheme {
        // Replace with real JSON input when available
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
                  "value": "1000"
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