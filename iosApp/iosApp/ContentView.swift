import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    var config:HomeScreenConfig

    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(config: config)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView( config: HomeScreenConfig(
                                          screenTitle: "iOS | Just Check",
                                          language: "en",
                                          initialData: []
                                      ))
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



